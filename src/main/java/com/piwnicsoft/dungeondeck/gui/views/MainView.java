package com.piwnicsoft.dungeondeck.gui.views;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@Slf4j
@SpringView(name = MainView.VIEW_NAME)
public class MainView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "";

    @Autowired
    private Navigator navigator;

    @PostConstruct
    void init() {
        Label label = new Label("DungeonDeck pomoże Ci w prowadzeniu niezapomnianej przygody.");
        addComponent(label);
        setComponentAlignment(label, Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeEvent event) {
        Notification.show("Witaj w DungeonDeck!");
    }
}
