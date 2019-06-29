package hu.frontrider.modeleditor.resources

import hu.frontrider.modeleditor.Editor
import hu.frontrider.modeleditor.Identifier
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when` as mockitoWhen

internal class ResourcePackEditorTest {

    lateinit var resourcePackManager: ResourcePackManager
    lateinit var resourcePackEditor: ResourcePackEditor
    @BeforeEach
    fun setUp() {
        resourcePackManager = mock(ResourcePackManager::class.java)

        mockitoWhen(resourcePackManager.getFiles()).thenReturn(
            arrayListOf(
                "assets/modid/models/block/test.json",
                "assets/modid/textures/block/test.json",
                "assets/modid/blockstates/test.json",
                "assets/modid/lang/en_us.json"
            )
        )
        resourcePackEditor = ResourcePackEditor(resourcePackManager)
    }

    @AfterEach
    fun tearDown() {
    }

    @Nested
    @DisplayName("when getting a datatype we can filter for ")
    inner class DataTypes{

        @Test
        @DisplayName("models")
        fun getModelType() {
            val items = resourcePackEditor.getItems(Editor.Types.MODEL.toString())
            assertEquals(1,items.size)
            assertEquals("assets/modid/models/block/test.json",items[Identifier("modid","block/test")])
        }

        @Test
        @DisplayName("textures")
        fun getTextureType() {
            val items = resourcePackEditor.getItems(Editor.Types.TEXTURE.toString())
            assertEquals(1,items.size)
            assertEquals("assets/modid/textures/block/test.json",items[Identifier("modid","block/test")])
        }

        @Test
        @DisplayName("blockstates")
        fun getBlockstateType() {
            val items = resourcePackEditor.getItems(Editor.Types.BLOCKSTATE.toString())
            assertEquals(1,items.size)
            assertEquals("assets/modid/blockstates/test.json",items[Identifier("modid","test")])
        }

        @Test
        @DisplayName("language")
        fun getLangType() {
            val items = resourcePackEditor.getItems(Editor.Types.LANGUAGE.toString())
            assertEquals(1,items.size)
            assertEquals("assets/modid/lang/en_us.json",items[Identifier("modid","en_us")])
        }


    }

    @Test
    fun display() {


    }
}