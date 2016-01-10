package lv.proq.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * Created by Artyom on 1/10/2016.
 */

@UIScope
@SpringView(name = "page1")
public class Page1 extends VerticalLayout implements View {

    @Autowired
    private Greeter greeter;

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    void init() {
        addComponent(new Label("Page 1"));
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("Showing page 1");
    }
}