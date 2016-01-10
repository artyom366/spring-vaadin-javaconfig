package lv.proq.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * Created by Artyom on 1/10/2016.
 */
@UIScope
@SpringView(name = "test")
public class LoginView extends VerticalLayout implements View {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    void init() {
        addComponent(new Label("This is the default view"));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
