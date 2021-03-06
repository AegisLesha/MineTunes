package vazkii.minetunes.player.chooser;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

import vazkii.minetunes.player.chooser.action.ISelectorAction;

public class FileSelector extends JFrame {

	private static final int WIDTH = 200;
	private static final int HEIGHT = 75;

	JButton selectButton;
	JFileChooser fileChooser;
	JPanel panel = new JPanel();
	ISelectorAction action;

	public FileSelector(FileFilter filter, int type, ISelectorAction action) {
		super("");
		this.action = action;

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		fileChooser = new JFileChooser();
		if(filter != null) {
			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(filter);
		}
		fileChooser.setFileSelectionMode(type);
		
		int i = fileChooser.showOpenDialog(this);

		if(i == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			action.select(file);
			dispose();
		}
	}

}
