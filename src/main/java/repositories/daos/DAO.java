package repositories.daos;

import java.util.List;

public interface DAO {
    public <T> List<T> buscarTodos();
    public <T> T buscar(int id);
    public <T> List<T> buscarTodosPorId(int id);
    public <T> List<T> buscarTodosXId(int id);
    public <T> List<T> buscarSugeridos(int id);
    public void agregar(Object unObjeto);
    public void modificar(Object unObjeto);
    public void eliminar(Object unObjeto);
	public <T> List<T> buscarPorGuardarropa(int id);

}
