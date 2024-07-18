import com.example.request.CreateNewPet
import com.example.request.CreateNewUser
import kotlin.random.Random

open class TestBase {
    fun addNewPet(
        id: Int = Random.nextInt(1, 999),
        name: String = "Max",
        category: CreateNewPet.Category = CreateNewPet.Category(
            id = Random.nextInt(1, 999),
            name = "CategoryName"
        ),
        photoUrls: List<String> = listOf("www.google.ru"),
        status: String = "NewPets",
        tags: List<CreateNewPet.Tag> = listOf(
            CreateNewPet.Tag(
                id = Random.nextInt(1, 999),
                name = "TagName"
            )
        ),
    ): CreateNewPet {
        return CreateNewPet(
            id = id,
            name = name,
            category = category,
            photoUrls = photoUrls,
            status = status,
            tags = tags
        )
    }

    fun newUser(
        id: Int = Random.nextInt(1, 999),
        email: String = "s@test.com",
        firstName: String = "RedHead_test",
        lastName: String = "RedHead",
        password: String = "test",
        phone: String = "89160870000",
        userStatus: Int = 1,
        username: String = "RedHead_MN"
    ): CreateNewUser {
        return CreateNewUser(
            id = id,
            email = email,
            firstName = firstName,
            lastName = lastName,
            phone = phone,
            password = password,
            username = username,
            userStatus = userStatus
        )
    }
}