public class ContainerOfObjects {
    // variaveis de instâncio
    private final int DEFAULT_SIZE = 100;
    private Object objects[];
    private int counter = 0;

    /**
     * Método construtor de objects
     * @param objects
     */
    public ContainerOfObjects(Object[] objects) {
        this.objects = objects;
    }

    /**
     *
     * Construtor que cria array de objects com Default size 100
     */
    public ContainerOfObjects() {
        objects = new Object[DEFAULT_SIZE];
    }

    /**
     * Construtor que cria array de objects com tamanho definido pelo user
     *
     * @param maxSize
     */
    public ContainerOfObjects(int maxSize) {
        objects = new Object[maxSize];
    }

    /**
     * Método que adiciona objects ao array
     *
     * @param newObject
     * @return
     */
    protected boolean addObject(Object newObject) {
        if (counter < objects.length) {
            objects[counter] = newObject;
            counter += 1;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método que remove objects do array
     *
     * @param position
     * @return
     */
    protected Object removeObject(int position) {
        if (position < objects.length && position != -1) {
            if (objects[position] == null) {
                System.out.println("Objecto não existe");
                return null;
            } else {
                Object delete = objects[position];
                objects[position] = null;
                for (int i = position; i < (counter - 1); i++) {
                    objects[i] = objects[i + 1];
                }
                counter -= 1;
                objects[counter] = null;
                return delete;
            }
        } else {
            System.out.println("Posição Inexistente");
            return null;
        }
    }

    /**
     * Método que substitui objects do array por outros inseridos pelo user
     *
     * @param position
     * @param newObject
     * @return
     */
    protected boolean setObject(int position, Object newObject) {
        if (position < objects.length) {
            if (objects[position] == null) {
                System.out.println("Não existe nenhum objeto nesta postição.");
                return false;
            } else {
                objects[position] = newObject;
                return true;
            }
        } else {
            System.out.println("Posição Inexistente");
            return false;
        }
    }

    /**
     * Método que encontra o object pretendido
     *
     * @param obj
     * @return
     */
    protected int findObject(Object obj) {
        for (int i = 0; i < objects.length && objects[i] != null; i++) {
            if (objects[i].equals(obj)) {
                System.out.println("Objeto encontrado!");
                return i;
            }
        }
        System.out.println("Objeto nao encontrado!");
        return -1;
    }

    /**
     * Método que verifica a existência de um object no array
     *
     * @param obj
     * @return
     */
    protected boolean hasObject(Object obj) {
        for (int i = 0; i < objects.length && objects[i] != null; i++) {
            if (objects[i].equals(obj)) {
                System.out.println("Objeto Existe!");
                return true;
            }
        }
        System.out.println("Objeto nao existe!");
        return false;
    }

    /**
     * Método que imprime a informação dos objects no array
     *
     *
     */
    protected void printall() {
        for (int i = 0; i < objects.length && objects[i] != null; i++) {
            System.out.println(objects[i].toString());
        }
    }

    /**
     * Método de acesso para obter a referencia do Array de objetos
     *
     * @return
     */
    public Object[] getObject() {
        return objects;
    }

    /**
     * Método para obter parte do array com informação
     *
     * @return
     */
    protected Object[] getObjects() {
        Object[] out = new Object[counter];
        System.arraycopy(objects, 0, out, 0, counter);
        return out;
    }
}