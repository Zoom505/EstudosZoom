import java.util.Arrays;

import javax.swing.JOptionPane;

public class Exercicios {
	public static void main(String[] args) {

		int pagamento = 0;

		pagamento = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Digite o valor do pagamento (Máx. 50.000)"));

		if (pagamento > 0 && pagamento < 50001) {

			int numeroDeMoedas = 0;
			numeroDeMoedas = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Digite a quantidade de moedas existentes em seu País "
							+ "(Máx. 100 moedas diferentes"));

			if (numeroDeMoedas > 0 && numeroDeMoedas < 101) {

				int arrayDasMoedas[] = new int[numeroDeMoedas];

				String valorDasMoedas = JOptionPane.showInputDialog(null,
						"Digite o valor das moedas separados"
								+ " por vírgula (e sem espaço)");

				String tar = valorDasMoedas;
				String valorIndividualMoeda[] = tar.split("\\,");

				int contagemDeNumeroDeMoedas = 0;

				contagemDeNumeroDeMoedas = valorDasMoedas.split("\\,").length;

				if (contagemDeNumeroDeMoedas == numeroDeMoedas) {

					int numeroDentroDoArray = 0;
					while (numeroDentroDoArray < numeroDeMoedas) {

						arrayDasMoedas[numeroDentroDoArray] = Integer
								.parseInt(valorIndividualMoeda[numeroDentroDoArray]);

						numeroDentroDoArray = numeroDentroDoArray + 1;
					}

					Arrays.sort(arrayDasMoedas);

					int moedasUtilizadas[] = new int[numeroDeMoedas];
					numeroDentroDoArray = numeroDeMoedas;

					while (numeroDentroDoArray > 0) {

						numeroDentroDoArray = numeroDentroDoArray - 1;
						moedasUtilizadas[numeroDentroDoArray] = pagamento
								/ arrayDasMoedas[numeroDentroDoArray];
						pagamento = pagamento
								% arrayDasMoedas[numeroDentroDoArray];

					}

					if (pagamento % arrayDasMoedas[numeroDentroDoArray] == 0) {

						numeroDentroDoArray = numeroDeMoedas;
						while (numeroDentroDoArray > 0) {
							numeroDentroDoArray = numeroDentroDoArray - 1;
							if (moedasUtilizadas[numeroDentroDoArray] != 0) {

								System.out.println("Você precisará de "

								+ moedasUtilizadas[numeroDentroDoArray]
										+ " moedas de "
										+ arrayDasMoedas[numeroDentroDoArray]
										+ " $");
							}

						}
						numeroDentroDoArray = numeroDeMoedas;
						int resultadoFinal = 0;
						while (numeroDentroDoArray > 0) {
							numeroDentroDoArray = numeroDentroDoArray - 1;
							resultadoFinal = resultadoFinal
									+ moedasUtilizadas[numeroDentroDoArray];

						}

						System.out.println("Num total MÍNIMO de "
								+ resultadoFinal + " moedas.");

					} else {
						System.out
								.println("É impossível pagar sem sobrar troco!");

					}

				} else {

					JOptionPane
							.showMessageDialog(
									null,
									"O número de valores digitados para cada moeda "
											+ "não bate com o número de moedas informado!");

				}

			} else {

				JOptionPane.showMessageDialog(null,
						"Número de moedas não suportado!");

			}

		} else {

			JOptionPane.showMessageDialog(null,
					"Valor de compra não suportado!");

		}

	}
} 

