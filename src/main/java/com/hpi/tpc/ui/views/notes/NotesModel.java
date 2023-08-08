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
            .setProperty("tda.token.refresh", "V1Muaw0QY70gxZ/ekpH4AJQpj+d1dKi0waSvy6MVGRFGWsjcvHJXDUcQwT+5/Kqi8AMgu5X+h/mLhCuW5xPYiHz4QybnYPaiRY/H6vUn4v2ntgCSOTB/A2kH+Kw/+ERFIhRcLhpPTzzMP++Dtu20QHUmUxpSO2iFlQ7AWOB75uAeSGTfGpE+lN5mqJ4V9XZEMO5eUWkKQ+VF2X02FeL1WimP7ZiOW0EUhxnXAXf1DDlc5TTK4nStjsoQ95Bv/LzbCmLrkJWQGGDdRx62d+oGDEP/RZVCEeZoqafXdKcMHGUr7aOPXLN4OJgz843SipcWTFTa3/Ru630kxRzvUL7V/86N32fFQ2JZMeW0qpgHSNi3STY4A/QakMCdBn+dOjecWRLCzRcUBix0/h4hCuBncv83c7GPunES3gJXzmc64sCXaw/yOwuNrdkcIDb100MQuG4LYrgoVi/JHHvlwXMDwvtoqWgHw4Zn/U4GeURnzCDpIrjWZ1n+9WQQ+R3Wi306Ynx/WGJhK4y6KxRvowREVxnCSU3PxXTIqziGwAGCSjtWwIntJ6T2db3RJsC4AQDZzvzryFfSpyKlIjbE0iOcTCQ0CGAQYbFPYZjzCxEKMEprfll8Cf07bjtSg63RMaEH4msDKLHNtCfSTWJlVCOqd3Fq+YrqVEkVISFt5LSk0ChAvyrTQjZw+rDgMVMqQZvYEhH9mpOUpaqg7cm74xTwXBfTu63P8leMyMLWC4hj6H3J056FS/8cB4pqZ9MwoR8tquGrm2lOgW3HEEnXdwAT6c3ZlTbonkZptTBoBoUj6q8W2leCuCTaIoztUOhvAQaceqYEbdloh22kGlz+VviWhEgzaRPVfiPhnpCJfHwUA2ZyFuLr4UuPs52Q1+sR9VYXXs9qsQlnQX0=212FD3x19z9sWBHDJACbC00B75E");
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
