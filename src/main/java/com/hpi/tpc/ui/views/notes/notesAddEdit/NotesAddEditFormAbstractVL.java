package com.hpi.tpc.ui.views.notes.notesAddEdit;

import com.hpi.tpc.ui.views.notes.NotesAddEditFormTitleVL;
import com.hpi.tpc.ui.views.notes.NotesAddEditControlsHL;
import com.hpi.tpc.data.entities.*;
import com.hpi.tpc.ui.views.baseClass.*;
import com.hpi.tpc.ui.views.notes.*;
import com.studerw.tda.model.quote.*;
import com.vaadin.flow.component.combobox.*;
import com.vaadin.flow.component.orderedlayout.*;
import com.vaadin.flow.component.textfield.*;
import com.vaadin.flow.data.binder.*;
import com.vaadin.flow.data.value.*;
import com.vaadin.flow.router.*;
import com.vaadin.flow.spring.annotation.*;
import lombok.*;
import org.springframework.beans.factory.annotation.*;

/**
 * makes direct request for data from model
 * does not change data;
 * user actions are sent to the controller
 * dumb, just builds the view
 */
@UIScope
@VaadinSessionScope
@org.springframework.stereotype.Component
public abstract class NotesAddEditFormAbstractVL
    extends ViewBaseVL
    implements BeforeEnterObserver
{

    @Autowired private NotesModel notesModel;

    //must be the same as the data model fields
    @Getter private final TextField ticker;
    @Getter private final NumberField iPrice;
    @Getter private final TextField description;
    @Getter private final NumberField units;
    @Getter private final ComboBox<String> action;
    @Getter private final ComboBox<String> triggerType;
    @Getter private final TextField alert;
    @Getter private final TextArea notes;

    @Getter private final NotesAddEditControlsHL controlsHL;

    private Boolean inPrice = false;

    public NotesAddEditFormAbstractVL()
    {
        this.setClassName("notesAddEditFormAbstractVL");
        this.setMaxWidth("100vw");
        this.setMaxHeight("100vh");

        this.ticker = new TextField();
        this.ticker.setRequiredIndicatorVisible(true);
        this.ticker.setAutofocus(true);
        this.ticker.setAutoselect(true);

        this.iPrice = new NumberField();
        this.iPrice.setRequiredIndicatorVisible(true);

        this.description = new TextField();

        this.units = new NumberField();
        this.units.setRequiredIndicatorVisible(true);

        this.alert = new TextField();
        this.notes = new TextArea();

        this.action = new ComboBox<>("", "Buy", "Sell", "Hold",
            "Watch", "Hedge", "Other");

        this.triggerType = new ComboBox<>("", "Date", "Price", "Other");

        this.controlsHL = new NotesAddEditControlsHL();
    }

    private Boolean checkRequired()
    {
        if (!this.ticker.getValue().isEmpty()
            && !this.notesModel.getQuote().getSymbol().isEmpty()
            && !this.notesModel.getQuote().getDescription().isEmpty())
        {
            if (this.notesModel.getQuote() instanceof ForexQuote)
            {
                if (((ForexQuote) (this.notesModel.getQuote())).getLastPriceInDouble().doubleValue() > 0.0)
                {
                    return true;
                }
            }

            if (this.notesModel.getQuote() instanceof FutureOptionQuote)
            {
                if (((FutureOptionQuote) (this.notesModel.getQuote())).getLastPriceInDouble().doubleValue() > 0.0)
                {
                    return true;
                }
            }

            if (this.notesModel.getQuote() instanceof FutureQuote)
            {
                if (((FutureQuote) (this.notesModel.getQuote())).getLastPriceInDouble().doubleValue() > 0.0)
                {
                    return true;
                }
            }

            if (this.notesModel.getQuote() instanceof OptionQuote)
            {
                if (((OptionQuote) (this.notesModel.getQuote())).getLastPrice().doubleValue() > 0.0)
                {
                    return true;
                }
            }

            if (this.notesModel.getQuote() instanceof EquityQuote)
            {
                if (((EquityQuote) (this.notesModel.getQuote())).getLastPrice().doubleValue() > 0.0)
                {
                    return true;
                }
            }

            if (this.notesModel.getQuote() instanceof EtfQuote)
            {
                if (((EtfQuote) (this.notesModel.getQuote())).getLastPrice().doubleValue() > 0.0)
                {
                    return true;
                }
            }

            if (this.notesModel.getQuote() instanceof MutualFundQuote)
            {
                if (((MutualFundQuote) (this.notesModel.getQuote())).getClosePrice().doubleValue() > 0.0)
                {
                    return true;
                }
            }
        }

        return false;
    }

    public void doLayout()
    {
        HorizontalLayout h1, h3, h4, h5;

        this.ticker.setPlaceholder("Ticker*");
        this.ticker.setMaxWidth("180px");
        this.ticker.setValueChangeMode(ValueChangeMode.ON_CHANGE);
        this.notesModel.getBinder().forField(this.ticker)
            .withValidator(e ->
            {
                Quote quote;
                quote = null;
                if (this.notesModel.getIsSave())
                {
                    //on save, we reset the ticker to empty 
                    //do not want that to show as an error
//                    this.notesModel.setIsSave(false);
                    return true;
                }

                //setting other values here causes repeat validations
                //and repeated calls for a quote
                if (this.inPrice)
                {
                    return true;
                }

                if (this.ticker.getValue().isEmpty())
                {
                    //cannot set iPrice here as we get multiple fields marked invalid
                    //and repeated validations
                    //client cannot save anyway
                    //this.iPrice.setValue(null);
                    //this.description.setValue("");
//                    this.controlsHL.getButtonAddSave().setEnabled(false);

                    return false;
                }

                //only look for new quote on add; retain initial price on edit
                //todo: this could fail on edit if the ticker no longer exists
                try
                {
                    quote = this.notesModel.getTickerInfo(this.ticker.getValue());
                } catch (RuntimeException f)
                {
                    this.controlsHL.getButtonAddSave().setEnabled(false);

                    return false;
                }

                if (quote != null)
                {
                    this.inPrice = true;

                    if (this.notesModel.getIsAdd())
                    {
                        //only update these on Add, not Edit
                        //clear data related to previous ticker
                        this.iPrice.setValue(0.0);
                        this.description.setValue("");

                        if (quote instanceof EquityQuote equityQuote1)
                        {
                            this.iPrice.setValue((equityQuote1.getLastPrice()).doubleValue());
                            this.description.setValue(equityQuote1.getDescription());
                        }

                        if (quote instanceof EtfQuote etfQuote1)
                        {

                            this.iPrice.setValue((etfQuote1.getLastPrice()).doubleValue());
                            this.description.setValue(etfQuote1.getDescription());
                        }

                        if (quote instanceof MutualFundQuote mfQuote1)
                        {

                            this.iPrice.setValue((mfQuote1.getClosePrice()).doubleValue());
                            this.description.setValue(mfQuote1.getDescription());
                        }

                        if (quote instanceof IndexQuote idxQuote1)
                        {

                            this.iPrice.setValue((idxQuote1.getLastPrice()).doubleValue());
                            this.description.setValue(idxQuote1.getDescription());
                        }

                        if (quote instanceof FutureQuote futureQuote1)
                        {

                            this.iPrice.setValue((futureQuote1.getLastPriceInDouble()).doubleValue());
                            this.description.setValue(futureQuote1.getDescription());
                        }

                        if (quote instanceof FutureOptionQuote futureOptionQuote1)
                        {

                            this.iPrice.setValue((futureOptionQuote1.getLastPriceInDouble()).doubleValue());
                            this.description.setValue(futureOptionQuote1.getDescription());
                        }

                        if (quote instanceof ForexQuote forexQuote1)
                        {

                            this.iPrice.setValue((forexQuote1.getLastPriceInDouble()).doubleValue());
                            this.description.setValue(forexQuote1.getDescription());
                        }
                    }

//                    this.iPrice.setValue((equityQuote.getLastPrice()).doubleValue());
//                    this.description.setValue(equityQuote.getDescription());
                    if (this.checkRequired())
                    {
                        this.controlsHL.getButtonAddSave().setEnabled(true);

                        //reset to default
                        this.notesModel.setIsAdd(false);
                        this.inPrice = false;
                        return true;
                    }
                } else
                {
                    //reset to default
                    this.notesModel.setIsAdd(false);
                    this.inPrice = false;
                    return false;
                }

                //reset to default
                this.notesModel.setIsAdd(false);
                this.inPrice = false;

                return false;
            }, "Invalid", ErrorLevel.ERROR)
            .bind(NoteModel::getTicker, NoteModel::setTicker);

        this.action.setMaxWidth("100px");
        this.notesModel.getBinder()
            .forField(this.action)
            .bind(NoteModel::getAction, NoteModel::setAction);

        this.triggerType.setMaxWidth("100px");
        this.notesModel.getBinder()
            .forField(this.triggerType)
            .bind(NoteModel::getTriggerType, NoteModel::setTriggerType);

        this.alert.setPlaceholder("Alert");
        this.alert.setMaxWidth("180px");
        this.notesModel.getBinder()
            .forField(this.alert)
            .bind(NoteModel::getTrigger, NoteModel::setTrigger);

        this.description.setPlaceholder("Description*");
        this.description.setMinWidth("297px");
        this.notesModel.getBinder()
            .forField(this.description)
            .withValidator(e ->
            {
                if (this.description.getValue().isEmpty())
                {
                    this.controlsHL.getButtonAddSave().setEnabled(false);
                    return false;
                } else
                {
                    if (this.checkRequired())
                    {
                        this.controlsHL.getButtonAddSave().setEnabled(true);
                        return true;
                    }
                }
                return false;
            }, "Invalid", ErrorLevel.ERROR)
            .bind(NoteModel::getDescription, NoteModel::setDescription);

        this.notes.setPlaceholder("Enter notes");
        this.notes.setMinHeight("90px");
        this.notes.setMaxHeight("250px");
        this.notes.setVisible(true);
        this.notes.setMinWidth("297px");
        this.notesModel.getBinder()
            .forField(this.notes)
            .bind(NoteModel::getNotes, NoteModel::setNotes);

        this.units.setPlaceholder("Units*");
        this.units.setMaxWidth("140px");
        this.notesModel.getBinder()
            .forField(this.units)
            .withValidator(e ->
            {
                if (this.units.getValue() == null || this.units.getValue() < 1.0)
                {
                    this.controlsHL.getButtonAddSave().setEnabled(false);
                    return false;
                } else
                {
                    if (this.checkRequired())
                    {
                        this.controlsHL.getButtonAddSave().setEnabled(true);
                        return true;
                    }
                }

                return false;
            }, "Invalid", ErrorLevel.ERROR)
            .bind(NoteModel::getUnits, NoteModel::setUnits);

        this.iPrice.setPlaceholder("Price*");
        this.iPrice.setMaxWidth("140px");
        this.notesModel.getBinder()
            .forField(this.iPrice)
            //            .asRequired()
            //            .withNullRepresentation(0.0)
            .withValidator(e ->
            {
                if (this.iPrice.getValue() == null || this.iPrice.getValue() < 1.0)
                {
                    this.controlsHL.getButtonAddSave().setEnabled(false);
                    return false;
                } else
                {
                    if (this.checkRequired())
                    {
                        this.controlsHL.getButtonAddSave().setEnabled(true);
                        return true;
                    }
                }

                return false;
            }, "Invalid", ErrorLevel.ERROR)
            .bind(NoteModel::getIPrice, NoteModel::setIPrice);

        //title
//        this.add(new NotesAddFormTitleVL("Add a note ..."));
        //first row
        h1 = new HorizontalLayout(this.ticker, this.action);
        //second row
//        h2 = new HorizontalLayout(this.notes);
        //third row
        h3 = new HorizontalLayout(this.units, this.iPrice);
        //fourth row
        h4 = new HorizontalLayout(this.triggerType, this.alert);
        //fifth row
        h5 = new HorizontalLayout(this.description);

        this.add(h1, this.notes, h3, h4, h5);

        this.add(this.controlsHL);
    }

    public void buildForm(String formTitle)
    {
        //title
        this.add(new NotesAddEditFormTitleVL(formTitle));

        this.doLayout();
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event)
    {
        //initial button settings upon entry
////        this.controlsHL.getButtonAddSave().setVisible(true);
//        this.controlsHL.getButtonAddSave().setEnabled(false);
//
////        this.controlsHL.getButtonAddCancel().setVisible(true);
//        this.controlsHL.getButtonAddCancel().setEnabled(true);
//        this.controlsHL.getButtonAddCancel().setText("Close");
//
////        this.controlsHL.getButtonAddArchive().setVisible(true);
//        this.controlsHL.getButtonAddArchive().setEnabled(true);
    }
}
