import com.example.apiFactory.ApiFactory.petApi
import com.example.apiFactory.ApiFactory.storeApi
import com.example.response.GetPetByID
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import retrofit2.Response
import kotlin.random.Random

@DisplayName("Тесты по добавлению и получению питомца")
class TestPet {

    @Test
    fun testFindPetByPetId() {
        val petId = 5                       //Random.nextInt(1, 150000)
        val test = petApi.findPetById(petId).execute()
        val id = test.body()?.id
        val message = test.body()
        println(message)
        Assertions.assertTrue(test.isSuccessful)
        Assertions.assertEquals(petId, id)

    }

    @Test
    fun testAddNewPetInStore() {
        val test = petApi.addNewPetToTheStore(55).execute()
        val body = test.body()
        println(body)
    }
}