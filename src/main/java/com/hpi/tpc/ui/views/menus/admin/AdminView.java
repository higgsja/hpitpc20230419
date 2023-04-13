package com.hpi.tpc.ui.views.menus.admin;

import static com.hpi.tpc.AppConst.*;
import com.hpi.tpc.prefs.*;
import com.hpi.tpc.services.*;
import com.hpi.tpc.ui.views.main.*;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.*;
import com.vaadin.flow.router.*;
import com.vaadin.flow.spring.annotation.*;
import javax.annotation.*;
import javax.annotation.security.*;
import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.rowset.*;

/**
 * makes direct request for data from model
 * does not change data;
 * user actions are sent to the controller
 * dumb, just builds the view
 */
@UIScope
@VaadinSessionScope
@org.springframework.stereotype.Component
@Route(value = ROUTE_ADMIN_VIEW, layout = MainLayout.class)
@PageTitle(TITLE_PAGE_ADMIN)

@NoArgsConstructor
@PermitAll
public class AdminView
    extends VerticalLayout
    implements BeforeEnterObserver, BeforeLeaveObserver {
    @Autowired private TPCDAOImpl tpcService;
    @Autowired private AdminModel adminModel;
    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private MainLayout appController;
    @Autowired private PrefsController prefsController;

    @PostConstruct
    private void construct() {
        this.setClassName("adminView");
//        this.setSizeFull();
    }

    @PreDestroy
    private void destruct() {

    }

    public void doDisplay() {
        SqlRowSet rowSet;
        String keyValue;
        Span aSpan;

        rowSet = this.jdbcTemplate.queryForRowSet(
            "select KeyValue from hlhtxc5_dmOfx.TPCHelp where KeyId = 'AdminHelp';");

        keyValue = "";
        while (rowSet.next()) {
            //only one
            keyValue = rowSet.getString("KeyValue");
        }

        aSpan = new Span();
        aSpan.getElement().setProperty("innerHTML", keyValue);

        this.add(aSpan);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        this.tpcService.AppTracking("TPC:Admin");
        this.removeAll();
        this.doDisplay();

        if (prefsController.getPref("TPCDrawerClose").
            equalsIgnoreCase("yes")) {
            appController.setDrawerOpened(false);
        }
    }

    @Override
    public void beforeLeave(BeforeLeaveEvent event) {
        //not hit
        int i = 0;
//        this.removeAll();
    }
}
