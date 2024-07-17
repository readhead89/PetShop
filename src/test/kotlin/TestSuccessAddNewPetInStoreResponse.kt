import com.example.apiFactory.ApiFactory.petApi
import com.example.apiFactory.ApiFactory.logger
import io.qameta.allure.Step
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("CRUD тесты")
class TestSuccessAddNewPetInStoreResponse : TestBase() {

    @Test
    @DisplayName("Создание и поиск нового питомца")
    fun testAddPetAndFindCreatedPet() {
        Step("Создаем нового питомца")
        val pet = petApi.addNewPetToTheStore(addNewPet()).execute()

        Step("Достем его id")
        val id = pet.body()?.id
        val name = pet.body()?.name

        Step("Ищем по $id питомца")
        if (id != null) {
            petApi.findPetById(id).execute()
        }

        Step("Проверяем, что питомец создан успешно, и найден в базе")
        Assertions.assertTrue(pet.isSuccessful)
        Assertions.assertEquals(name, addNewPet().name)
        logger.debug("New Pet with id $id?, successful added in store")
    }
}