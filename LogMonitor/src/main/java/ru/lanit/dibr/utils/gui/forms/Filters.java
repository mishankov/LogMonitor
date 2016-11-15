package ru.lanit.dibr.utils.gui.forms;

import ru.lanit.dibr.utils.core.BlockSearchFilter;
import ru.lanit.dibr.utils.core.LineSearchFilter;
import ru.lanit.dibr.utils.core.SearchFilter;
import ru.lanit.dibr.utils.gui.LogPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Vova
 * Date: 12.11.13
 * Time: 4:05
 */
public class Filters extends JFrame {
    private JPanel panel1;
    private JPanel directGrepPanel;
    private JPanel directBlockPanel;
    private JPanel reverseBlockPanel;
    private JPanel reverseGrepPanel;
    private JTabbedPane tabbedPane1;
    private JButton applyButton;

    private SearchFilter directBlock;
    private SearchFilter reverseBlock;
    private SearchFilter directGrep;
    private SearchFilter reverseGrep;

    private Map<SearchFilter, JPanel> filtersMap = new HashMap<SearchFilter, JPanel>();

    public static void main(String[] args) {
        new Filters("123", null, new BlockSearchFilter("", false), new BlockSearchFilter("", true), new LineSearchFilter(false), new LineSearchFilter(true)).setVisible(true);
    }

    public Filters(String title, LogPanel logPanel, SearchFilter directBlock, SearchFilter reverseBlock, SearchFilter directGrep, SearchFilter reverseGrep) throws HeadlessException {
        super(title);

        this.directBlock = directBlock;
        this.reverseBlock = reverseBlock;
        this.directGrep = directGrep;
        this.reverseGrep = reverseGrep;

        $$$setupUI$$$();
        ((FilterPanel) directBlockPanel).init(logPanel);
        ((FilterPanel) reverseBlockPanel).init(logPanel);
        ((FilterPanel) directGrepPanel).init(logPanel);
        ((FilterPanel) reverseGrepPanel).init(logPanel);

        refresh();

        applyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((FilterPanel) directBlockPanel).apply();
                ((FilterPanel) reverseBlockPanel).apply();
                ((FilterPanel) directGrepPanel).apply();
                ((FilterPanel) reverseGrepPanel).apply();
            }
        });

        add(panel1);
        pack();
//        setSize(550,500);
        setResizable(false);
    }

    public void addTo(SearchFilter filter) {
        ((FilterPanel) filtersMap.get(filter)).applyFilter(filter);
    }

    public void refresh() {
        ((FilterPanel) directBlockPanel).applyFilter(directBlock);
        filtersMap.put(directBlock, directBlockPanel);
        ((FilterPanel) reverseBlockPanel).applyFilter(reverseBlock);
        filtersMap.put(reverseBlock, reverseBlockPanel);
        ((FilterPanel) directGrepPanel).applyFilter(directGrep);
        filtersMap.put(directGrep, directGrepPanel);
        ((FilterPanel) reverseGrepPanel).applyFilter(reverseGrep);
        filtersMap.put(reverseGrep, reverseGrepPanel);
    }

    private void createUIComponents() {
        directBlockPanel = new FilterPanel("Show blocks");
        reverseBlockPanel = new FilterPanel("Hide blocks");
        directGrepPanel = new FilterPanel("Show lines");
        reverseGrepPanel = new FilterPanel("Hide lines");
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1 = new JTabbedPane();
        panel1.add(tabbedPane1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        tabbedPane1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Block filters", panel2);
        panel2.add(directBlockPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        panel2.add(reverseBlockPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("Line filters", panel3);
        panel3.add(directGrepPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        panel3.add(reverseGrepPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel4, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, new Dimension(-1, 23), new Dimension(-1, 23), new Dimension(-1, 23), 0, false));
        applyButton = new JButton();
        applyButton.setText("Apply");
        panel4.add(applyButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 20), new Dimension(-1, 20), new Dimension(-1, 20), 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panel4.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}