/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author Elena María Gómez Ríos, Jose Luis Martínez Ortiz
 */
public class Player {
    
    static final int MAXLEVEL = 10;
    
    private String name;
    private int level;
    private boolean dead;
    private boolean canISteal;
    
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    
    private BadConsequence pendingBadConsequence;
    protected Player enemy;
    
    
    //Constructores
    public Player(String name){
        this.name=name;
        level=1;
        dead = true;
        canISteal = true;
        hiddenTreasures = new ArrayList();
        visibleTreasures = new ArrayList();
        enemy = null;
        pendingBadConsequence = new BadConsequence("",0,0,0);
    }
    
    public Player(Player p){
        name=p.name;
        level=p.level;
        dead = p.dead;
        canISteal = p.canISteal;
        hiddenTreasures = p.hiddenTreasures;
        visibleTreasures = p.visibleTreasures;
        enemy = p.enemy;
        pendingBadConsequence = p.pendingBadConsequence;
    }
    
    protected int getOponentLevel (Monster m){
        return m.getCombatLevel();
    }
    
    protected boolean shouldConvert(){
        boolean shouldC;
        Dice d = Dice.getInstance();
        int n = d.nextNumber();
        if (n==1)
            shouldC=true;
        else
            shouldC=false;
        
        return shouldC;
    }
    
    // Devuelve el nombre del jugador;
    public String getName(){
        return name;
    }
    
   // Devuelve la vida al jugador, modificando el atributo correspondiente
    private void bringToLife(){
        dead = false;
    }
    
    // Devuelve el nivel de combate del jugador. Que viene dado por
    // su nivel más los bonus que le proporcionan los tesoros que
    // tenga equipados
    protected int getCombatLevel(){
        int combatLevel=level;
        for(Treasure ht : visibleTreasures) {
            combatLevel += ht.getBonus();
        }
        return combatLevel;
    }
    
    // Incrementa el nivel del jugador en i niveles
    private void incrementLevels(int i){
        level += i;
    }
    
    // Decrementa el nivel del jugador en i niveles
    private void decrementLevels(int i){
        if (level-i<=0)
            level=1;
        else
            level -= i;
    }
    
    // Asigna el mal rollo al jugador
    private void setPendingBadConsequence(BadConsequence b){
        pendingBadConsequence = b;
    }
    
    /**
     * Aplica el buen rolloo del monstruo vencido al jugador, sumando los niveles
     * correspondientes y pidiendo al CardDealer que le dé el número de 
     * tesoros indicado en el buen rollo del monstruo. Esos tesoros se añaden
     * a sus tesoros
     * @param m Monstruo vencido
     */
    private void applyPrize(Monster m){
        int nLevels = m.getLevelsGained();
        incrementLevels(nLevels);
        int nTreasures = m.getTreasuresGained();
        if (nTreasures>0){
            CardDealer dealer = CardDealer.getInstance();
            
            Treasure treasure;
            for (int i=1; i<=nTreasures; i++){
                treasure = dealer.nextTreasure();
                hiddenTreasures.add(treasure);
            }
        }
    }
    
    /**
     * Realiza el mal rollo de un monstruo contra el jugador.
     * Aplica las consecuencias que puede y las que no las guarda
     * en el mal rollo pendiente.
     * @param m monstruo con el que ha perdido
     */
    private void applyBadConsequence(Monster m){
        BadConsequence badConsequence = m.getBadConsequence();
        int nLevels = badConsequence.getLevels();
        decrementLevels(nLevels);
        BadConsequence pendingBad = badConsequence.adjustToFitTreasureList(visibleTreasures, hiddenTreasures);
        setPendingBadConsequence(pendingBad);
    }
    
    /* Comprueba si el tesoro t se puede pasar de oculto a visible */
    private boolean canMakeTreasureVisible(Treasure t){
        boolean sePuede = true;
        /*Solo podrá tener equipado un tesoro de cada tipo, 
        salvo para el caso de tesoros de una mano de los
        que podrá tener equipados hasta 2.*/
        int oneHand=0;
        boolean bothhands=false;
        for (int i=0; i<visibleTreasures.size()  && sePuede; i++){
            if (t.getType()!= TreasureKind.ONEHAND){
                //Si ya lo tiene equipado no se puede equipar
                if (t.getType()==visibleTreasures.get(i).getType())
                    sePuede=false;     
                if (visibleTreasures.get(i).getType()==TreasureKind.ONEHAND)
                    oneHand++;
            }else{
                //Cuento cuantas armas de una mano tiene equipadas
                if (t.getType()==visibleTreasures.get(i).getType())
                    oneHand++;
            }
            
            //Compruebo si tiene equipado un arma de dos manos      
            if (visibleTreasures.get(i).getType()==TreasureKind.BOTHHANDS)
                bothhands=true;
        }
        if(sePuede){
            /*Si se tienen equipado 1 ó 2 tesoros de una mano, no se podrá 
            tener equipado ningún tesoro de dos manos.*/ 
            if (oneHand>0 && (t.getType()== TreasureKind.BOTHHANDS))
                sePuede=false;

            /*Si se tiene equipado un tesoro de dos manos, no se podrá tener 
            equipado ningún tesoro de una mano.
            Si el tipo es ONEHAND y ya tiene dos equipadas, no se puede
            */            
            else if(t.getType() == TreasureKind.ONEHAND)
                if(oneHand==2 || bothhands)
                    sePuede=false;
        }      
    
        return sePuede;
    }
    
    // Devuelve el número de tesoros visibles de tipo tKind que tiene el jugador
    private int howManyVisibleTreasures(TreasureKind tKind){
        int numero=0;
        for (Treasure vt : visibleTreasures) {
            if(vt.getType() == tKind)
                numero++;
        }
        return numero;
    }
    
    // Cambia el estado de jugador a muerto, modificando el correspondiente
    // atributo. 
    private void dieIfNoTreasures(){
        if( hiddenTreasures.isEmpty() && visibleTreasures.isEmpty())
            dead = true;
    }
    
    // Devuelve true si el jugador está muerto, false en caso contrario
    public boolean isDead(){  
        return dead;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }
    
    /**
     * Si el nivel de combate del jugador supera al del monstruo, se aplica el buen rollo 
     * y se puede ganar el combate o el juego, en otro caso, el jugador pierde el combate 
     * y se aplica el mal rollo correspondiente.
     * @param m Monstruo con el que combate
     * @return resultado del combate.
     */
    public CombatResult combat(Monster m){
        CombatResult cr;
        int myLevel = getCombatLevel();
        int monsterLevel = getOponentLevel(m);
        
        if (myLevel>monsterLevel){
            applyPrize(m);
            
            if (level>=MAXLEVEL)
                cr = CombatResult.WINGAME;
            else
                cr = CombatResult.WIN;
        }else{
            applyBadConsequence(m);
            if(shouldConvert()){
                cr = CombatResult.LOSEANDCONVERT;
            }else{
               cr = CombatResult.LOSE; 
            }
            
        }
        
        return cr;
    }
    
    /**
     * Pasa un objeto oculto de la mano del jugador a visible.
     * @param t tesoro que se hace visible.
     */
    public void makeTreasureVisible(Treasure t){
        boolean canI = canMakeTreasureVisible(t);
        if (canI){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }
    
    /**
     * Se elimina un tesoro visible.
     * Si tiene un mal rollo pendiente e implica eliminar un tesoro visible
     * se elimina del mal rollo tambien. Luego se comprueban si el jugador
     * esta vivo.
     * @param t tesoro que se va a descartar.
     */
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
        if( (pendingBadConsequence != null) && (!pendingBadConsequence.isEmpty()) ){
            pendingBadConsequence.substracVisibleTreasure(t);
        }
        
        dieIfNoTreasures();
    }
    
    /**
     * Se elimina un tesoro oculto.
     * Si tiene un mal rollo pendiente e implica eliminar un tesoro oculto
     * se elimina del mal rollo tambien. Luego se comprueban si el jugador
     * esta vivo.
     * @param t tesoro que se va a descartar.
     */
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
        if( (pendingBadConsequence != null) && (!pendingBadConsequence.isEmpty()) ){
            pendingBadConsequence.substracHiddenTreasure(t);
        }
        
        dieIfNoTreasures();
    }
    

    /**
     * Devuelve true cuando el jugador no tiene ningún mal rollo que cumplir
     * y no tiene más de 4 tesoros  ocultos, y false en caso contrario.
     * @return 
     */
    public boolean validState(){
        boolean state=false;
        if(pendingBadConsequence.isEmpty() && !(hiddenTreasures.size() > 4) )
            state = true;
        return state;
    }
    
    
    /**
     * Proporciona nuevos tesoros a un jugador cuando está en su primer turno o se ha 
     * quedado sin tesoros.
     * El número de tesoros que se les proporciona viene dado por el valor que saque al tirar
     * el dado.
     */
    public void initTreasures(){
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        bringToLife();
        Treasure treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        int number = dice.nextNumber();
        
        if (number>1){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        if (number==6){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }
    
    /**
     * Devuelve el nivel del jugador
     */
    public int getLevels(){
        return level;
    }
    
    
    /**
     * Comprueba si un jugador puede robar un tesoro a su enemigo.
     * Si se puede, el tesoro se almacenaŕa en ocultos.
     * El jugador no puede volver a robar otro tesoro durante la partida.
     * En el caso que no se haya podido robar el tesoro por algún motivo devuelve null
     * @return Treasure tesoro robado
     */
    public Treasure stealTreasure(){
        Treasure treasure = null;
        boolean canI = canISteal();
        if(canI){
            boolean canYou = enemy.canYouGiveMeATreasure();
            
            if (canYou){
                treasure = enemy.giveMeATreasure();
                hiddenTreasures.add(treasure);
                haveStolen();
            }
        }
        return treasure;
    }
    
    /**
     * Asigna valor al atributo que referencia al enemigo del jugador
     * @param enemy Enemigo que se asigna al jugador.
     */
    public void setEnemy(Player enemy){
        this.enemy=enemy;
    }
    
    /**
     * Devuelve un tesoro elegido al azar de entre los tesoros ocultos del jugador
     * @return el tesoro que se devuelve
     */
    private Treasure giveMeATreasure(){
        Treasure tesoro;
        //Genero un número aletorio
        int num=(int) (Math.random()*hiddenTreasures.size());
        //Elijo el tesoro a devolver
        tesoro = hiddenTreasures.get(num);
        //Elimino el tesoro
        hiddenTreasures.remove(num);
        return tesoro;
    }
    
    /**
     * Indica si el jugador ha robado antes o no un tesoro a su enemigo.
     * @return si el jugador puede robar.
     */
    public boolean canISteal(){
        return canISteal;
    }
    
    /**
     * Devuelve true si el jugador tiene tesoros para ser robados por otro 
     * jugador y false en caso contrario.
     * 
     */
    private boolean canYouGiveMeATreasure(){
        boolean numTreasure=false;
        if(!hiddenTreasures.isEmpty())
            numTreasure=true;
        return numTreasure;
    }
    
    /**
     * Cambia el atributo canISteal a false cuando el jugador roba un tesoro.
     */ 
    private void haveStolen(){
        canISteal= false;
    }
    
   /**
    * Elimina todos los tesoros del jugador.
    */
    public void discardAllTreasures(){
        ArrayList<Treasure> listTreasure = new ArrayList(new ArrayList(visibleTreasures));
        for(Treasure treasure:listTreasure){
            discardVisibleTreasure(treasure);
        }
        
        listTreasure = new ArrayList(new ArrayList(hiddenTreasures));
        for(Treasure treasure:listTreasure){
            discardHiddenTreasure(treasure);
        }
    }
    
    
    
    /**
     * Método que muestra player
     * @return un string con el nombre del jugador
     */
    @Override
    public String toString(){
        return getName()+"  level: "+level+"    dead: "+dead+"    enemy: "+enemy.name+"\n";
    }
}
