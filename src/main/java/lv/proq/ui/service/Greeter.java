package lv.proq.ui.service;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

/**
 * Created by Artyom on 1/10/2016.
 */

@UIScope
@SpringComponent
public class Greeter {
    public String sayHello() {
        return "Hello from bean " + toString();
    }
}