import com.example.request.NewPetAddInStoreRequest
import kotlin.random.Random

open class TestBase {
    fun addNewPet(
        id: Int = Random.nextInt(1, 999),
        name: String = "Max",
        category: NewPetAddInStoreRequest.Category = NewPetAddInStoreRequest.Category(
            id = Random.nextInt(1, 999),
            name = "CategoryName"
        ),
        photoUrls: List<String> = listOf("www.google.ru"),
        status: String = "NewPets",
        tags: List<NewPetAddInStoreRequest.Tag> = listOf(
            NewPetAddInStoreRequest.Tag(
                id = Random.nextInt(1, 999),
                name = "TagName"
            )
        ),
    ): NewPetAddInStoreRequest {
        return NewPetAddInStoreRequest(
            id = id,
            name = name,
            category = category,
            photoUrls = photoUrls,
            status = status,
            tags = tags
        )
    }
}