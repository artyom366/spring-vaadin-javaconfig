package lv.proq.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.sql.DataSource;

/**
 * Created by Artyom on 1/10/2016.
 */

@UIScope
@SpringComponent
public class LoginLayout extends VerticalLayout implements View {

    @Autowired
    DataSource dataSource;

//    @Autowired
//    private ReloadableResourceBundleMessageSource messageSource;

    @Autowired
    private AuthenticationManager manager;

    private VerticalLayout upperSection = new VerticalLayout();
    private HorizontalLayout lowerSection = new HorizontalLayout();
    private VerticalLayout menuLayout = new VerticalLayout();
    private VerticalLayout contentLayout = new VerticalLayout();


    public LoginLayout init() {

        setSizeFull();
        lowerSection.setSizeFull();
        menuLayout.setSizeFull();

        upperSection.addComponent(new Label("Header"));
        menuLayout.addComponent(new Label("Menu"));
        contentLayout.addComponent(new Label("Content"));

        lowerSection.addComponent(menuLayout);
        lowerSection.addComponent(contentLayout);

        addComponent(upperSection);
        addComponent(lowerSection);

        TextField userName = new TextField("Username");
        PasswordField password = new PasswordField("Password");
        Button signIn = new Button(/*messageSource.getMessage("login.btn", null, VaadinSession.getCurrent().getLocale())*/"Login");

        signIn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken("user", "pass");

                SecurityContextHolder.getContext()
                        .setAuthentication(manager.authenticate(authenticationToken));
            }
        });

        contentLayout.addComponent(userName);
        contentLayout.addComponent(password);
        contentLayout.addComponent(signIn);
        contentLayout.setMargin(true);
        contentLayout.setSpacing(true);

        setExpandRatio(upperSection, 0.2f);
        setExpandRatio(lowerSection, 1f);
        lowerSection.setExpandRatio(menuLayout, 0.7f);
        lowerSection.setExpandRatio(contentLayout, 1f);

        return this;
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
