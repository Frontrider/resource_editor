package hu.frontrider.modeleditor

import javafx.fxml.FXMLLoader
import java.io.InputStreamReader
import java.nio.file.Path
import java.util.*


fun <T>loadFxml(path: String): T {
    val fxmlLoader = FXMLLoader(ModelEditor::class.java.getResource(path));

    val lang = Properties();
     lang   .load(InputStreamReader(ModelEditor::class.java.getResourceAsStream("/lang/en_us.properties")))
    fxmlLoader.namespace.apply{
        lang.keys.forEach {
            this[it.toString()] = lang[it]
        }
    }

   return fxmlLoader.load<T>()
}