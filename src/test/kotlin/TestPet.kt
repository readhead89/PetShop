import com.example.apiFactory.ApiFactory.logger
import com.example.apiFactory.ApiFactory.petApi
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

@DisplayName("Тесты по добавлению и получению питомца")
class TestPet {

    @Test
    fun testFindPetByPetId() {
        val petId = 5                   //Random.nextInt(1, 150000)
        val test = petApi.findPetById(petId).execute()
        val id = test.body()?.id
        Assertions.assertTrue(test.isSuccessful)
        Assertions.assertEquals(petId, id)
        logger.debug("Requesting data for user123 $petId")
    }

    /*
    @Test
    fun testAddNewPetInStore() {
        val test = petApi.addNewPetToTheStore(55).request().body()
        println(test)
    }
     */
}