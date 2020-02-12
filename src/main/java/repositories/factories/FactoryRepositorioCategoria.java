package repositories.factories;

import config.Config;
import models.CategoriaModel;
import repositories.RepositorioCategoria;
//import repositories.daos.DAOMemoria;
import repositories.daos.DAOMySQL;

public class FactoryRepositorioCategoria {
    private static RepositorioCategoria repo;

    public static RepositorioCategoria get(){
        if(repo == null){
            boolean useDataBase = Config.useDataBase;
            if(useDataBase){
                repo = RepositorioCategoria.getInstance(new DAOMySQL(CategoriaModel.getInstance()));
            }
            else{
             //   repo = RepositorioPrenda.getInstance(new DAOMemoria(DataUsuario.getList()));
            }
        }
        return repo;
    }
}
