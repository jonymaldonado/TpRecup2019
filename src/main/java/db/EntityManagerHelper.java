package db;



import javax.persistence.*;

//import algoritmoAleatorio.Algoritmo;

import java.util.function.Supplier;

public class EntityManagerHelper {

    private static EntityManagerFactory emf;

    private static ThreadLocal<EntityManager> threadLocal;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("db");
            threadLocal = new ThreadLocal<>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static EntityManager entityManager() {
        return getEntityManager();
    }

    public static EntityManager getEntityManager() {
        EntityManager manager = threadLocal.get();
        if (manager == null || !manager.isOpen()) {
            manager = emf.createEntityManager();
            threadLocal.set(manager);
        }
        return manager;
    }

    public static void closeEntityManager() {
        EntityManager em = threadLocal.get();
        threadLocal.set(null);
        em.close();
    }

    public static void beginTransaction() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        if(!tx.isActive()){
            tx.begin();
        }
    }

    public static void commit() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        if(tx.isActive()){
            tx.commit();
        }

    }

    public static void rollback(){
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        if(tx.isActive()){
            tx.rollback();
        }
    }

    public static Query createQuery(String query) {
        return getEntityManager().createQuery(query);
    }

    public static void persist(Object o){
        entityManager().persist(o);
    }

    public static void withTransaction(Runnable action) {
        withTransaction(() -> {
            action.run();
            return null;
        });
    }
    public static <A> A withTransaction(Supplier<A> action) {
        beginTransaction();
        try {
            A result = action.get();
            commit();
            return result;
        } catch(Throwable e) {
            rollback();
            throw e;
        }
    }

    /* public void index() throws Exception {

        String negro = "#000000";
        String blanco = "#FFFFFF";
        String amarillo= "#FFFF00";
        String celeste = "#2271B3";
        String gris = "#9C9C9C";
        String bordo = "#800040";
        String verde = "#008F39";
        //CREACION DE USUARIOS

        Usuario alejandro = new Usuario("Alejandro","Roco","aroco", "123456", false);
        Usuario julieta = new Usuario("Julieta","Azul","jazul", "123456", true);

        //CREACION DE CATEGORIAS
        Categoria superior = new Categoria("SUPERIOR");
        Categoria inferior = new Categoria("INFERIOR");
        Categoria calzado = new Categoria("CALZADO");
        Categoria accesorio = new Categoria("ACCESORIO");

        //CREACION DE TIPOS DE TELA
        TipoTela algodon=new TipoTela("Algodon");
        TipoTela jean=new TipoTela("Jean");
        TipoTela cuero=new TipoTela("Cuero");
        TipoTela nylon=new TipoTela("Nylon");
        TipoTela seda=new TipoTela("Seda");
        TipoTela poliester=new TipoTela("Poliester");
        TipoTela lycra=new TipoTela("Lycra");

        //CREACION DE TIPOS DE PRENDA
        TipoPrenda tRemera=new TipoPrenda("Remera");
        TipoPrenda tMusculosa=new TipoPrenda("Musculosa");
        TipoPrenda tSueter=new TipoPrenda("Sueter");
        TipoPrenda tCampera=new TipoPrenda("Campera");
        TipoPrenda tBuzo=new TipoPrenda("Buzo");
        TipoPrenda gorra=new TipoPrenda("gorra");

        TipoPrenda tPantalonLargo=new TipoPrenda("Pantalon Largo");
        TipoPrenda tPantalonCorto=new TipoPrenda("Pantalon Corto");
        TipoPrenda tBermuda=new TipoPrenda("Bermuda");
        TipoPrenda tPollera=new TipoPrenda("Pollera");
        TipoPrenda tCalza=new TipoPrenda("Calza");

        TipoPrenda tZapatillas =new TipoPrenda("Zapatillas");
        TipoPrenda tZapatos =new TipoPrenda("Zapatos");
        TipoPrenda tSandalias =new TipoPrenda("Sandalias");

        //TIPOS DE PRENDA VALIDOS PARA UNA CATEGORIA
        superior.agregarTipoPrendaValida(tRemera);
        superior.agregarTipoPrendaValida(tMusculosa);
        superior.agregarTipoPrendaValida(tSueter);
        superior.agregarTipoPrendaValida(tCampera);
        superior.agregarTipoPrendaValida(tBuzo);

        inferior.agregarTipoPrendaValida(tPantalonLargo);
        inferior.agregarTipoPrendaValida(tPantalonCorto);
        inferior.agregarTipoPrendaValida(tBermuda);
        inferior.agregarTipoPrendaValida(tPollera);
        inferior.agregarTipoPrendaValida(tCalza);

        calzado.agregarTipoPrendaValida(tZapatillas);
        calzado.agregarTipoPrendaValida(tZapatos);
        calzado.agregarTipoPrendaValida(tSandalias);
        
        accesorio.agregarTipoPrendaValida(gorra);

        //CONFIGURACION DE LOS TIPOS DE PRENDA
        tRemera.setCategoria(superior);
        tRemera.agregarTelasValidas(algodon);
        tRemera.agregarTelasValidas(seda);
        tRemera.agregarTelasValidas(poliester);
        tRemera.agregarTelasValidas(lycra);

        tMusculosa.setCategoria(superior);
        tMusculosa.agregarTelasValidas(algodon);
        tMusculosa.agregarTelasValidas(lycra);

        tSueter.setCategoria(superior);
        tSueter.agregarTelasValidas(algodon);
        tSueter.agregarTelasValidas(seda);
        tSueter.agregarTelasValidas(poliester);

        tCampera.setCategoria(superior);
        tCampera.agregarTelasValidas(algodon);
        tCampera.agregarTelasValidas(seda);
        tCampera.agregarTelasValidas(poliester);
        tCampera.agregarTelasValidas(cuero);
        tCampera.agregarTelasValidas(nylon);
        
        gorra.setCategoria(accesorio);
        gorra.agregarTelasValidas(algodon);

        
        accesorio.agregarTipoPrendaValida(gorra);
        tBuzo.setCategoria(superior);
        tBuzo.agregarTelasValidas(algodon);
        tBuzo.agregarTelasValidas(lycra);
        tBuzo.agregarTelasValidas(poliester);
        tBuzo.agregarTelasValidas(nylon);

        tPantalonLargo.setCategoria(inferior);
        tPantalonLargo.agregarTelasValidas(algodon);
        tPantalonLargo.agregarTelasValidas(jean);
        tPantalonLargo.agregarTelasValidas(seda);
        tPantalonLargo.agregarTelasValidas(poliester);
        tPantalonLargo.agregarTelasValidas(nylon);

        tPantalonCorto.setCategoria(inferior);
        tPantalonCorto.agregarTelasValidas(algodon);
        tPantalonCorto.agregarTelasValidas(jean);
        tPantalonCorto.agregarTelasValidas(seda);
        tPantalonCorto.agregarTelasValidas(poliester);
        tPantalonCorto.agregarTelasValidas(nylon);

        gorra.setCategoria(accesorio);
        gorra.agregarTelasValidas(algodon);
        tBermuda.setCategoria(inferior);
        tBermuda.agregarTelasValidas(algodon);
        tBermuda.agregarTelasValidas(jean);
        tBermuda.agregarTelasValidas(seda);
        tBermuda.agregarTelasValidas(poliester);
        tBermuda.agregarTelasValidas(nylon);

        tPollera.setCategoria(inferior);
        tPollera.agregarTelasValidas(algodon);
        tPollera.agregarTelasValidas(jean);
        tPollera.agregarTelasValidas(seda);
        tPollera.agregarTelasValidas(poliester);
        tPollera.agregarTelasValidas(nylon);

        tCalza.setCategoria(inferior);
        tCalza.agregarTelasValidas(algodon);
        tCalza.agregarTelasValidas(seda);
        tCalza.agregarTelasValidas(poliester);
        tCalza.agregarTelasValidas(nylon);

        tZapatillas.setCategoria(calzado);
        tZapatillas.agregarTelasValidas(cuero);
        tZapatillas.agregarTelasValidas(nylon);

        tZapatos.setCategoria(calzado);
        tZapatos.agregarTelasValidas(cuero);

        tSandalias.setCategoria(calzado);
        tSandalias.agregarTelasValidas(cuero);

        //CREACION DE PRENDAS PARA USUARIO AROCO
        Prenda gorraC = new Prenda("Gorra",accesorio,gorra.getTipoPrenda(),algodon.getNombreTela(), negro,"",null,1,5);
        Prenda remeraCRMC = new Prenda("Remera cuello redondo manga corta",superior,tRemera.getTipoPrenda(),algodon.getNombreTela(), negro,"",null,1,5);
        Prenda remeraEVMC = new Prenda("Remera Escote en V manga corta",superior,tRemera.getTipoPrenda(),lycra.getNombreTela(),blanco,"",null,1,5);
        Prenda musculosa = new Prenda("Musculosa",superior,tMusculosa.getTipoPrenda(),lycra.getNombreTela(),amarillo,"",null,1,3);
        Prenda campera = new Prenda("Campera",superior,tCampera.getTipoPrenda(),cuero.getNombreTela(),blanco,"",null,3,13);
        Prenda sueter = new Prenda("Sueter",superior,tSueter.getTipoPrenda(),poliester.getNombreTela(),blanco,"",null,2,15);
        Prenda bermuda = new Prenda("Bermuda",inferior,tBermuda.getTipoPrenda(),jean.getNombreTela(),celeste,"",null,1,3);
        Prenda pantalonLargo = new Prenda("Pantalon Largo",inferior,tPantalonLargo.getTipoPrenda(),jean.getNombreTela(),gris,"",null,1,8);
        Prenda zapatillas = new Prenda("Zapatillas",calzado,tZapatillas.getTipoPrenda(),cuero.getNombreTela(),bordo,"",null,1,0);
        Prenda zapatos = new Prenda("Zapatos",calzado,tZapatos.getTipoPrenda(),cuero.getNombreTela(),negro,"",null,1,0);

        //CREACION DE PRENDAS PARA USUARIO JAZUL
        Prenda gorraA = new Prenda("Gorrito",accesorio,gorra.getTipoPrenda(),algodon.getNombreTela(), negro,"",null,1,5);
        Prenda remeraCRML = new Prenda("Remera cuello redondo manga larga",superior,tRemera.getTipoPrenda(),lycra.getNombreTela(),amarillo,"",null,1,8);
        Prenda remeraEVMl = new Prenda("Remera Escote en V manga larga",superior,tRemera.getTipoPrenda(),algodon.getNombreTela(),blanco,"",null,1,8);
        Prenda musculosa2 = new Prenda("Musculosa",superior,tMusculosa.getTipoPrenda(),lycra.getNombreTela(),verde,"",null,1,3);
        Prenda sueter2 = new Prenda("Sueter",superior,tSueter.getTipoPrenda(),poliester.getNombreTela(),gris,"",null,2,15);
        Prenda pollera = new Prenda("Pollera",inferior,tPollera.getTipoPrenda(),seda.getNombreTela(),negro,"",null,1,3);
        Prenda calza = new Prenda("Calza",inferior,tCalza.getTipoPrenda(),nylon.getNombreTela(),negro,"",null,1,5);
        Prenda buzo = new Prenda("Buzo",superior,tBuzo.getTipoPrenda(),algodon.getNombreTela(),blanco,"",null,1,13);
        Prenda zapatos2 = new Prenda("Zapatos",calzado,tZapatos.getTipoPrenda(),cuero.getNombreTela(),negro,"",null,1,0);
        Prenda sandalias = new Prenda("Sandalias",calzado,tSandalias.getTipoPrenda(),cuero.getNombreTela(),negro,"",null,1,0);

        Guardarropa guardarropaAroco = new Guardarropa("Guardarropas de Aroco");
        Guardarropa guardarropaJazul = new Guardarropa("Guardarropas de Jazul");

        
        
        julieta.agregarGuardarropa(guardarropaJazul);
        alejandro.agregarGuardarropa(guardarropaAroco);

        gorraA.setG(guardarropaAroco);
        remeraCRMC.setG(guardarropaAroco);
        remeraEVMC.setG(guardarropaAroco);
        musculosa.setG(guardarropaAroco);
        campera.setG(guardarropaAroco);
        sueter.setG(guardarropaAroco);
        bermuda.setG(guardarropaAroco);
        pantalonLargo.setG(guardarropaAroco);
        zapatillas.setG(guardarropaAroco);
        zapatos.setG(guardarropaAroco);
        guardarropaAroco.agregarPrendaCreada(remeraCRMC);
        guardarropaAroco.agregarPrendaCreada(remeraEVMC);
        guardarropaAroco.agregarPrendaCreada(musculosa);
        guardarropaAroco.agregarPrendaCreada(campera);
        guardarropaAroco.agregarPrendaCreada(sueter);
        guardarropaAroco.agregarPrendaCreada(bermuda);
        guardarropaAroco.agregarPrendaCreada(pantalonLargo);
        guardarropaAroco.agregarPrendaCreada(zapatillas);
        guardarropaAroco.agregarPrendaCreada(zapatos);
        guardarropaAroco.agregarPrendaCreada(gorraA);

        remeraCRML.setG(guardarropaJazul);
        gorraC.setG(guardarropaJazul);
        remeraEVMl.setG(guardarropaJazul);
        musculosa2.setG(guardarropaJazul);
        sueter2.setG(guardarropaJazul);
        pollera.setG(guardarropaJazul);
        calza.setG(guardarropaJazul);
        buzo.setG(guardarropaJazul);
        zapatos2.setG(guardarropaJazul);
        sandalias.setG(guardarropaJazul);

        guardarropaJazul.agregarPrendaCreada(remeraCRML);
        guardarropaJazul.agregarPrendaCreada(gorraC);
        guardarropaJazul.agregarPrendaCreada(remeraEVMl);
        guardarropaJazul.agregarPrendaCreada(musculosa2);
        guardarropaJazul.agregarPrendaCreada(sueter2);
        guardarropaJazul.agregarPrendaCreada(pollera);
        guardarropaJazul.agregarPrendaCreada(calza);
        guardarropaJazul.agregarPrendaCreada(buzo);
        guardarropaJazul.agregarPrendaCreada(zapatos2);
        guardarropaJazul.agregarPrendaCreada(sandalias);

        Ciudad laBoca = new Ciudad("La Boca");
        Ciudad cordoba = new Ciudad("Cordoba");
        Ciudad laPlata = new Ciudad("La Plata");

        Algoritmo alg = new Algoritmo();
        //guardarropaJazul.generarTodos();
        //guardarropaAroco.generarTodos();
        
        beginTransaction();

        getEntityManager().persist(laBoca);
        getEntityManager().persist(cordoba);
        getEntityManager().persist(laPlata);

        getEntityManager().persist(guardarropaAroco);
        getEntityManager().persist(guardarropaJazul);

        getEntityManager().persist(alejandro);
        getEntityManager().persist(julieta);
/*
        for (int i=0;i<guardarropaAroco.getAtuendosTotales().size();i++) {
          	 EntityManagerHelper.getEntityManager().persist(guardarropaAroco.atuendosTotales.get(i));
        }
        for (int i=0;i<guardarropaJazul.getAtuendosTotales().size();i++) {
         	 EntityManagerHelper.getEntityManager().persist(guardarropaJazul.atuendosTotales.get(i));
        }
        
        
        getEntityManager().persist(algodon);
        getEntityManager().persist(nylon);
        getEntityManager().persist(jean);
        getEntityManager().persist(cuero);
        getEntityManager().persist(seda);
        getEntityManager().persist(poliester);
        getEntityManager().persist(lycra);
        
        getEntityManager().persist(superior);
        getEntityManager().persist(inferior);
        getEntityManager().persist(calzado);
        getEntityManager().persist(accesorio);
        
        getEntityManager().persist(gorra);
        getEntityManager().persist(tRemera);
        getEntityManager().persist(tPantalonCorto);
        getEntityManager().persist(tPantalonLargo);
        getEntityManager().persist(tBermuda);
        getEntityManager().persist(tBuzo);
        getEntityManager().persist(tCalza);
        getEntityManager().persist(tCampera);
        getEntityManager().persist(tMusculosa);
        getEntityManager().persist(tPollera);
        getEntityManager().persist(tRemera);
        getEntityManager().persist(tSandalias);
        getEntityManager().persist(tSueter);
        getEntityManager().persist(tZapatillas);
        getEntityManager().persist(tZapatos);

        getEntityManager().persist(remeraCRMC);
        getEntityManager().persist(remeraEVMC);
        getEntityManager().persist(musculosa);
        getEntityManager().persist(campera);
        getEntityManager().persist(sueter);
        getEntityManager().persist(bermuda);
        getEntityManager().persist(pantalonLargo);
        getEntityManager().persist(zapatillas);
        getEntityManager().persist(zapatos);
        getEntityManager().persist(gorraC);
        getEntityManager().persist(gorraA);

        getEntityManager().persist(remeraCRML);
        getEntityManager().persist(remeraEVMl);
        getEntityManager().persist(musculosa2);
        getEntityManager().persist(sueter2);
        getEntityManager().persist(pollera);
        getEntityManager().persist(calza);
        getEntityManager().persist(buzo);
        getEntityManager().persist(zapatos2);
        getEntityManager().persist(sandalias);

        commit();

    }*/
}//fin entity


