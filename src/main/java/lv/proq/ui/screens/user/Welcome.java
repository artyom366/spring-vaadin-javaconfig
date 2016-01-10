package lv.proq.ui.screens.user;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Artyom on 1/10/2016.
 */

@UIScope
@SpringView(name = "")
public class Welcome extends VerticalLayout implements View {
    public Welcome() {
        addComponent(new Label("Welcome"));
    }
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("Showing Welcome page");
    }
}