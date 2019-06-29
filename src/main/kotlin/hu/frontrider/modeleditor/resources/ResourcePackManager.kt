package hu.frontrider.modeleditor.resources

import java.io.File
import java.util.zip.ZipEntry
import java.util.zip.ZipFile
import Mockable

@Mockable
class ResourcePackManager {
    private val files = ArrayList<String>()

    fun getFiles() = files

    fun loadResourcePackFromZip(path: String) {
        ZipFile(path).use { zipFile ->
            val zipEntries = zipFile.entries()
            while (zipEntries.hasMoreElements()) {
                val fileName = (zipEntries.nextElement() as ZipEntry).name
                println(fileName)
            }
        }
    }

    fun loadFolder(path: String) {
        File(path).walkTopDown().forEach { println(it) }
    }
}