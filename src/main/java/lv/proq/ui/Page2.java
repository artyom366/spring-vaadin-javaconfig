package lv.proq.ui;

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
@SpringView(name = "page1")
public class Page2 extends VerticalLayout implements View {
    public Page2() {
        addComponent(new Label("Page 2"));
    }
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("Showing page 2");
    }
}
