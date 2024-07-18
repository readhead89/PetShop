
import com.example.apiFactory.ApiFactory.userApi
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

//@DisplayName("CRUD тесты с пользователем")
class TestUser : TestBase() {
    @Test
    @DisplayName("Создание пользователя")
    fun testCreateNewUser() {
        userApi.createNewUser(newUser()).execute()


    }
}