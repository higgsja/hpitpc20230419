package com.hpi.tpc.ui.views.notes;

import com.hpi.tpc.data.entities.*;
import com.hpi.tpc.ui.views.baseClass.*;
import com.studerw.tda.client.*;
import com.studerw.tda.model.quote.*;
import com.vaadin.flow.data.binder.*;
import com.vaadin.flow.spring.annotation.*;
import java.util.*;
import lombok.*;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * handles state of application
 * contains objects representing the data
 * provides ways to query and change the data
 * responds to requests from View and instructions from Controller
 */
@UIScope
@VaadinSessionScope
@Component
public class NotesModel
    extends MVCModelBase
{

    @Setter @Getter private NoteModel noteModel;
    @Getter private List<NoteModel> dataProvider;
    @Getter private final BeanValidationBinder<NoteModel> binder;

    private final Properties props;
    private final HttpTdaClient httpTdaClient;
    @Getter private Quote quote;
    @Getter @Setter private Boolean isSave;
    @Getter @Setter private Boolean isAdd;

    public NotesModel()
    {
        this.binder = new BeanValidationBinder<>(NoteModel.class);
        this.props = new Properties();
        props.setProperty("tda.client_id", "VYEUORVKFCJSAZG9TBJOGSQZX8PKXWZB");
        props
            .setProperty("tda.token.refresh", "lUyLz3Gt68wSuHTmUoqC74T/9Zvkw5UO0R4+EMCsr2fr8H0XkJNLxU1F0Ot8/y5C9zbcTVCg+42wyNnupTbB9kKvZGN6YPVlNsV4PftUCw1aBa8G7lzJjsS3iuM6netPdioGFIBF6Yu+WHlLXGSTnJTIngi9FooVVHDf09LrEgtKc8lvGOydS/hnBoXh6IBuwxWIl7BDQEd8ODPla3gOc0bzsHC7F8b3mIhAb0A1/je+cYO1ylFRHwYdhV539nmFOOFtRDsu9qnSSuwUZNI5B5QC4m3ADOyxMscessIvCensxThZeR+78Zq+qq/kNdHl7BGMUJMWCXiZw0Y595ZUhaT3sSiDvv2fB8Q547sCjtfOShBIkVlXMjLTD9gNGabCukSjdp596ZZwqrjzawXiR+VWvPCzcSYGGPK7VSt58tQm7B31+cDh24P+qmY100MQuG4LYrgoVi/JHHvlqz7Ppr/QerKE8R54/azZkTgjvr0uPua9Bfbs6XH6dMEzdJ96RMybj5qGN8pEvGviilo2HHE0+OJSfc+5OR/DKEULy8UrMpt8lHA0drf3tesC2ZWIYy+nZPox6EmkujQPAhbbI7jLSefeacRPROREgMjtYDFp9mvKlaSUTCNKnR3bP/J1zMQd6yvglX88xEAj5X2UkC7Aa7tgHFIM4SbTO8BzIUZ7pprdfh0VfUBcPyMRRE+sELGaKPGPntdr2d+zlwA8n+XL2DwwbkVLJk4U6FPtZ+eCBwOTTJjW0WzRDUH4L2qfy+euIJnec5ppS8jdKkb1o34s29vY8jgjzMqszwKKXk7n/hz4noLGXaYSaCqzZFldb3LTloPUMb3OhiWpOaEOVy9g1oLpvvldJqBzb7dI2HH4gNhfvVSydzq7ZaoFSe3rPjFmK6uX8fg=212FD3x19z9sWBHDJACbC00B75E");
        props.setProperty("tda.account.id", "865-837053");
//        props.setProperty("tda.url", CMOfxDirectModel.getFIMODELS().
//            get(0).getHttpHost());
        props.setProperty("tda.debug.bytes.length", "-1");

        this.httpTdaClient = new HttpTdaClient(props);

        this.quote = null;
        this.isSave = false;
        this.isAdd = false;
    }

    public Quote getTickerInfo(String ticker)
    {
        return this.quote = this.httpTdaClient.fetchQuote(ticker);
    }

    public void getPrefs(String prefPrefix)
    {
//        this.prefsController.setDefaults("PortfolioTrack");
//        this.prefsController.readPrefsByPrefix("PortfolioTrack");
//        this.selectedTrackActive = this.prefsController
//            .getPref("PortfolioTrackActive").equals("Yes");
//        this.selectedTrackOpen = this.prefsController
//            .getPref("PortfolioTrackOpen").equals("Yes");
    }

    public void writePrefs()
    {
//        //preferences, update the hashmap, then write to database
//        this.prefsController.setPref("PortfolioTrackActive",
//            selectedTrackActive ? "Yes" : "No");
//        this.prefsController.setPref("PortfolioTrackOpen",
//            selectedTrackOpen ? "Yes" : "No");
//        
//        this.prefsController.writePrefsByPrefix("PortfolioTrack");
    }

//    public void setSelectNoteModel(NoteModel noteModel)
//    {
//        //without the session variable, this could be simple setter
//        this.setSelectedNoteModel(noteModel);
//    }
    /**
     * Save the note to the database
     * need to come in with the NoteModel from the form.
     *
     * @param isArchive: true if archiving a note
     */
    public void saveUpdate(Boolean isArchive)
    {
        //not hit
        NoteModel tempNoteModel;

        if (isArchive)
        {
            this.serviceTPC.AppTracking("TPC:Notes:Edit:Archive");
        } else
        {
            this.serviceTPC.AppTracking("TPC:Notes:Edit:Save");
        }

        //get data from the form
        tempNoteModel = new NoteModel(
            //these are key fields
            this.noteModel.getJoomlaId(),
            //null for add
            this.noteModel.getTStamp(),
            //uppercase if a ticker
            this.noteModel.getTicker(),
            this.noteModel.getIPrice(),
            this.noteModel.getDescription(),
            this.noteModel.getNotes(),
            this.noteModel.getUnits(),
            NoteModel.setActionInt(this.noteModel.getAction()).toString(),
            NoteModel.setTriggerInt(this.noteModel.getTriggerType()).toString(),
            this.noteModel.getTrigger(),
            this.noteModel.getActive(),
            this.noteModel.getDateEntered()
        );

        this.serviceTPC.updateNote(tempNoteModel);
    }

    /**
     * Save the note to the database
     * need to come in with the NoteModel from the form.
     */
    public void saveAdd()
    {
        NoteModel tempNoteModel;

        this.serviceTPC.AppTracking("TPC:Notes:Add:Save");

        tempNoteModel = new NoteModel(
            //these are key fields
            this.noteModel.getJoomlaId(),
            //null for add
            this.noteModel.getTStamp(),
            //uppercase if a ticker
            this.noteModel.getTicker(),
            this.noteModel.getIPrice(),
            this.noteModel.getDescription(),
            this.noteModel.getNotes(),
            this.noteModel.getUnits(),
            NoteModel.setActionInt(this.noteModel.getAction()).toString(),
            NoteModel.setTriggerInt(this.noteModel.getTriggerType()).toString(),
            this.noteModel.getTrigger(),
            this.noteModel.getActive(),
            this.noteModel.getDateEntered()
        );

        this.serviceTPC.saveNote(tempNoteModel);
    }

    public void getData(String subset)
    {
        List<NoteModel> aList;

        aList = this.serviceTPC.getByJId(subset);

        this.dataProvider = aList;
    }

    @Override
    public void writePrefs(String prefix)
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
