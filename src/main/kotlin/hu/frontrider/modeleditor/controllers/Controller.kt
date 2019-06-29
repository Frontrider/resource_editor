package hu.frontrider.modeleditor.controllers

import javafx.event.Event
import javafx.scene.Node
import javafx.stage.Window


interface Controller {

    fun getWindow(event: Event): Window {
        return (event.target as Node).scene.window
    }
}