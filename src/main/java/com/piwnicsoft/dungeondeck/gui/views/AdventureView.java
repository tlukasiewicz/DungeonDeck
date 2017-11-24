package com.piwnicsoft.dungeondeck.gui.views;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringView(name = AdventureView.VIEW_NAME)
public class AdventureView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "adventure";

    public AdventureView(Navigator navigator) {
        TextField name = new TextField();
        name.setCaption("Podaj nazwę nowej przygody:");

        Button button = new Button("Stwórz przygodę.");
        button.addClickListener(e -> createAdventure());

        addComponents(name, button);
    }

    private void createAdventure() {
        addComponent(new Label("Przygoda w trakcie tworzenia!"));
    }

}
