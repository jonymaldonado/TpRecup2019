package repositories.factories;

import config.Config;
import models.GuardarropasModel;
import repositories.RepositorioGuardarropas;
import repositories.daos.DAOMySQL;


public class FactoryRepositorioGuardarropas {
    private static RepositorioGuardarropas repo;

    public static RepositorioGuardarropas get(){
        if(repo == null){
            boolean useDataBase = Config.useDataBase;
            if(useDataBase){
                repo = RepositorioGuardarropas.getInstance(new DAOMySQL(GuardarropasModel.getInstance()));
            }
            else{
                //repo = RepositorioGuardarropas.getInstance(new DAOMemoria(DataUsuario.getList()));
            }
        }
        return repo;
    }
}
