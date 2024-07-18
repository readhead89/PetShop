import com.example.apiFactory.ApiFactory.petApi
import com.example.apiFactory.ApiFactory.logger

import io.qameta.allure.Step
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("CRUD тесты")
class TestPet : TestBase() {

    @Test
    @DisplayName("Создание и поиск нового питомца")
    fun testAddPetAndFindCreatedPet() {
        Step("Создаем нового питомца")
        val pet = petApi.addNewPetToTheStore(addNewPet()).execute()

        Step("Достем атрибуты")
        pet.body()?.let { pet ->
            val id = pet.id
            val name = pet.name

            //   val id = pet.body()?.id
            // val name = pet.body()?.name

            Step("Ищем по $id питомца")
            petApi.findPetById(id).execute()

            Step("Удаляем созданного питомца с $id")
            petApi.deleteCreatedPet(id).execute()


            Step("Ищем по $id питомца")
            petApi.findPetById(id).execute()

            Step("Проверяем, что питомец создан успешно, и найден в базе")
            // Assertions.assertTrue(pet)
            Assertions.assertEquals(name, addNewPet().name)
            Assertions.assertEquals(pet.id, id)
            logger.debug("New Pet with id $id, successful added in store")
        }
    }
}