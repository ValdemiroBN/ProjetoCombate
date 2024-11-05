public class Champion {
    String nome;
    int ataque;
    int armadura;
    int vida;

    public Champion(String nome, int ataque, int armadura, int vida) {
        this.nome = nome;
        this.ataque = ataque;
        this.armadura = armadura;
        this.vida = vida;
    }

    public void takeDamage(int dano) {
        int danoEfetivo = dano - this.armadura;
        if (danoEfetivo < 1) {
            danoEfetivo = 1;
        }
        this.vida -= danoEfetivo;
        if (this.vida < 0) {
            this.vida = 0;
        }
    }

    public String status() {
        String estado = this.nome + ": " + this.vida + " vida";
        if (this.vida == 0) {
            estado += " (morreu)";
        }
        return estado;
    }

    public int getVida() {
        return vida;
    }

    public String getNome() {
        return nome;
    }
}