package repositories.factories;

import config.Config;
import models.PrendaModel;
import repositories.RepositorioPrenda;
//import repositories.daos.DAOMemoria;
import repositories.daos.DAOMySQL;

public class FactoryRepositorioPrenda {
    private static RepositorioPrenda repo;

    public static RepositorioPrenda get(){
        if(repo == null){
            boolean useDataBase = Config.useDataBase;
            if(useDataBase){
                repo = RepositorioPrenda.getInstance(new DAOMySQL(PrendaModel.getInstance()));
            }
            else{
             //   repo = RepositorioPrenda.getInstance(new DAOMemoria(DataUsuario.getList()));
            }
        }
        return repo;
    }
}
