package hu.frontrider.modeleditor.controllers

import hu.frontrider.modeleditor.Editor
import javafx.scene.Group
import javafx.scene.control.ListView
import javafx.scene.layout.AnchorPane
import javafx.stage.Stage

interface FieldGetter {
    var main: AnchorPane
    var componentList: ListView<*>
    var modelView: Group
    var editors:MutableList<Editor>
}