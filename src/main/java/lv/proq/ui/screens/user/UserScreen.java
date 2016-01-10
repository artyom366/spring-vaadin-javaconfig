package lv.proq.ui.screens.user;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import lv.proq.ui.service.Greeter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

/**
 * Created by Artyom on 1/10/2016.
 */

@Theme("mytheme")
@SpringUI(path = "user")
public class UserScreen extends UI {

    @Autowired
    private Greeter greeter;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SpringViewProvider viewProvider;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

//        Navigator navigator = new Navigator(this, this);
//        navigator.addView("", new Welcome());
//        navigator.addView("page1", new Page1());
//        navigator.addView("page2", new Page2());

        final VerticalLayout root = new VerticalLayout();
        root.setSizeFull();
        root.setMargin(true);
        root.setSpacing(true);
        setContent(root);

        final Panel viewContainer = new Panel();
        viewContainer.setSizeFull();
        root.addComponent(viewContainer);
        root.setExpandRatio(viewContainer, 1.0f);

        Navigator navigator = new Navigator(this, this);
        navigator.addProvider(viewProvider);
    }
}
