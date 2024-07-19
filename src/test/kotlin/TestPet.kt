import com.example.allure.AllureHelpers.allureStep
import com.example.apiFactory.ApiFactory.petApi
import io.qameta.allure.Step
import org.junit.jupiter.api.Assertions as Assert
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


import org.assertj.core.api.Assertions.assertThat

@DisplayName("CRUD тесты с питомцем")
class TestPet : TestBase() {
    @Test
    @DisplayName("Позитивный е2е тест")
    fun testAddPetAndFindCreatedPet() {
        val pet = allureStep("Создать нового питомца") {
            petApi.addNewPetToTheStore(addNewPet()).execute().body()
        }

        val id = allureStep("Получить id созданного питомца") {
            pet!!.id
        }

        val name = allureStep("Получить имя созданного питомца") {
            pet!!.name
        }

        allureStep("Проверяем что питомец с $id успешно находиится") {
            petApi.findPetById(id).execute()
        }

        allureStep("Удалить созданно питомца с именем $name  и айди $id") {
            petApi.deleteCreatedPet(id).execute()
        }
        allureStep("Проверяем что питомец с $id успешно находиится") {
            petApi.findPetById(id).execute()
        }

        allureStep("Проверки") {
            Assert.assertEquals(name, addNewPet().name)
            Assert.assertNotEquals(pet!!.id, id)
        }
    }
}
