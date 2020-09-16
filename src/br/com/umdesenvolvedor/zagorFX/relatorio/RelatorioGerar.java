package br.com.umdesenvolvedor.zagorFX.relatorio;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import javax.swing.JDialog;
import javax.swing.JFrame;

import br.com.umdesenvolvedor.zagorFX.utils.Propriedades;
import br.com.umdesenvolvedor.zagorFX.utils.TelaConfigSingleton;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.swing.JRViewer;

public class RelatorioGerar extends JDialog {
	private static final long serialVersionUID = 1L;

	TelaConfigSingleton tela = TelaConfigSingleton.getInstance();

	private String contexto = Propriedades.getPropriedades().getProperty("dir_relatorios");
	private int telaLargura = tela.getTelaLargura();
	private int telaAltura = tela.getTelaAltura();

	public RelatorioGerar() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}

			@Override
			public void windowClosed(WindowEvent e) {
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	public void gerar(String relatorio, Map<String, Object> parametros, DataSource dataSource) {

		String jrxml = contexto + relatorio;

		JasperReport report;
		JasperPrint print = null;

		try {
			report = JasperCompileManager.compileReport(jrxml);

			print = JasperFillManager.fillReport(report, parametros, dataSource.getConnection());

			dataSource.getConnection().close();
		} catch (Exception e) {
			System.err.println(e);
		}

		JRViewer view = new JRViewer(print);
		view.setOpaque(true);
		view.setVisible(true);
		this.add(view);
		this.setSize(telaLargura, telaAltura);
		this.setVisible(true);
	}

	public void gerar(String relatorio, List<?> lista) {
		String jrxml = contexto + relatorio;
		JRDataSource data = new JRBeanArrayDataSource(lista.toArray());

		JasperReport report;
		JasperPrint print = null;

		try {
			report = JasperCompileManager.compileReport(jrxml);

			print = JasperFillManager.fillReport(report, null, data);

		} catch (Exception e) {
			System.err.println(e);
		}

		JRViewer view = new JRViewer(print);
		view.setOpaque(true);
		view.setVisible(true);
		this.add(view);
		this.setSize(telaLargura, telaAltura);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
	}

}
