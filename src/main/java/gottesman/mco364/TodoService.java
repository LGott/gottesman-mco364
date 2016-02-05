package gottesman.mco364;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TodoService {

	@GET("/todos")
	Call<List<Todo>> listTodos();
	
	
}
