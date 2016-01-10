package lv.proq.ui.screens.login;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.sql.DataSource;

/**
 * Created by Artyom on 1/10/2016.
 */

@Theme("mytheme")
@SpringUI(path = "login")
public class LoginScreen extends UI {

    @Autowired
    DataSource dataSource;

    @Autowired
    private ReloadableResourceBundleMessageSource messageSource;

    @Autowired
    private AuthenticationManager manager;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setMargin(true);
        mainLayout.setSpacing(true);

        TextField userName = new TextField("Username");
        PasswordField password = new PasswordField("Password");

        Button signIn = new Button(messageSource.getMessage("login.btn", null, VaadinSession.getCurrent().getLocale()));

        signIn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userName.getValue(), password.getValue());

                SecurityContextHolder.getContext()
                        .setAuthentication(manager.authenticate(authenticationToken));
            }
        });

        mainLayout.addComponent(userName);
        mainLayout.addComponent(password);
        mainLayout.addComponent(signIn);

        setContent(mainLayout);
    }
}
