package repositories.factories;

import config.Config;
import models.AtuendoModel;
import repositories.RepositorioAtuendo;
import repositories.daos.DAOMySQL;

public class FactoryRepositorioAtuendo {
    private static RepositorioAtuendo repo;

    public static RepositorioAtuendo get(){
        if(repo == null){
            boolean useDataBase = Config.useDataBase;
            if(useDataBase){
                repo = RepositorioAtuendo.getInstance(new DAOMySQL(AtuendoModel.getInstance()));
            }
            else{
                //repo = RepositorioAtuendo.getInstance(new DAOMemoria(DataUsuario.getList()));
            }
        }
        return repo;
    }
}
