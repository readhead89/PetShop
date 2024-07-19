import com.example.allure.AllureHelper
import com.example.allure.AllureHelper.allureStep
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
        val pet =
            petApi.addNewPetToTheStore(addNewPet()).execute()


        Step("Достем атрибуты")
        pet.body()?.let { pet ->
            val id = pet.id
            val name = pet.name




            allureStep("Ищем по $id питомца") {
                petApi.findPetById(id).execute()
            }

            allureStep("Удаляем созданного питомца с $id") {
                petApi.deleteCreatedPet(id).execute()
            }

            allureStep("Проверяем что пришла ошибка, так как питомец по $id не найден") {
                petApi.findPetById(id).execute()
            }

            allureStep("Проверяем, что питомец создан успешно, и найден в базе") {
                Assert.assertEquals(name, addNewPet().name)
                Assert.assertNotEquals(pet.id, id)
            }
        }
    }
}






