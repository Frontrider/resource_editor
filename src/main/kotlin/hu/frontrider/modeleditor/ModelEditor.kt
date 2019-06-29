package hu.frontrider.modeleditor

import hu.frontrider.modeleditor.controllers.FieldGetter
import hu.frontrider.modeleditor.controllers.Main
import hu.frontrider.modeleditor.controllers.Texture
import javafx.application.Application
import javafx.event.ActionEvent
import javafx.fxml.FXMLLoader
import javafx.scene.Group
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.ListView
import javafx.scene.image.ImageView
import javafx.scene.layout.AnchorPane
import javafx.stage.Stage

class ModelEditor : Application(), FieldGetter, Main, Texture {
    override lateinit var texture: ImageView
    override var editors: MutableList<Editor> = ArrayList()
    override lateinit var main: AnchorPane
    override lateinit var componentList: ListView<*>
    override lateinit var modelView: Group


    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        val root = loadFxml<Parent>("/main.fxml")

        primaryStage.title = "Resource Editor"

        primaryStage.scene = Scene(root, 800.0, 500.0)
        primaryStage.show()
    }



}
fun main(args: Array<String>) {
    Application.launch(*args)
}