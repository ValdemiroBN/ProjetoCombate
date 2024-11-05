public class JogoDeCombate {
     Champion campeao1;
    Champion campeao2;
    int nTurnos;

    public JogoDeCombate(Champion campeao1, Champion campeao2, int nTurnos) {
        this.campeao1 = campeao1;
        this.campeao2 = campeao2;
        this.nTurnos = nTurnos;
    }

    public String iniciarCombate() {
        StringBuilder resultado = new StringBuilder();
        for (int turno = 1; turno <= nTurnos; turno++) {
            resultado.append("Turno ").append(turno).append(":\n");

            // Campeão 1 ataca Campeão 2
            campeao2.takeDamage(campeao1.ataque);
            resultado.append(campeao1.status()).append("\n");
            resultado.append(campeao2.status()).append("\n");

            // Verifica se Campeão 2 morreu
            if (campeao2.getVida() == 0) {
                break;
            }

            // Campeão 2 ataca Campeão 1
            campeao1.takeDamage(campeao2.ataque);
            resultado.append(campeao1.status()).append("\n");
            resultado.append(campeao2.status()).append("\n");

            // Verifica se Campeão 1 morreu
            if (campeao1.getVida() == 0) {
                break;
            }
        }
        resultado.append("FIM DO COMBATE");
        return resultado.toString();
    }
}