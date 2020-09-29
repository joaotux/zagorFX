package br.com.umdesenvolvedor.zagorFX.relatorio;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.PrinterName;
import javax.sql.DataSource;
import javax.swing.JDialog;
import javax.swing.JFrame;

import br.com.umdesenvolvedor.zagorFX.utils.Alerta;
import br.com.umdesenvolvedor.zagorFX.utils.Propriedades;
import br.com.umdesenvolvedor.zagorFX.utils.TelaConfigSingleton;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioGerar extends JDialog {
	private static final long serialVersionUID = 6775897406151070520L;

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

	public void gerar(String relatorio, Map<String, Object> parametros, DataSource dataSource, String impressora,
			Scene scene) {
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

		if (print.getPages().isEmpty()) {
			Alerta.alerta("Sem dados para exibir", AlertType.WARNING, scene);
		}

		if (impressora == null || impressora.isEmpty()) {
			JRViewer view = new JRViewer(print);
			view.setOpaque(true);
			view.setVisible(true);
			this.add(view);
			this.setSize(telaLargura, telaAltura);
			this.setVisible(true);
			this.setAlwaysOnTop(true);
		} else {
			imprime(print, impressora);
		}

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
		JasperViewer.viewReport(print);
	}

	private void imprime(JasperPrint jp, String impressora) {
		// TODO Auto-generated method stub
		PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
		// printRequestAttributeSet.add(MediaSizeName.ISO_A4); //setting page size
		printRequestAttributeSet.add(new Copies(1));

		PrinterName printerName = new PrinterName(impressora, null); // gets printer

		PrintServiceAttributeSet printServiceAttributeSet = new HashPrintServiceAttributeSet();
		printServiceAttributeSet.add(printerName);

		JRPrintServiceExporter exporter = new JRPrintServiceExporter();

		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
		exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);
		exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, printServiceAttributeSet);
		exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
		exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
		try {
			exporter.exportReport();
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

}
