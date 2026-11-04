package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import dao.PropertyDAO;
import model.Property;

public class DashboardFrame extends JFrame {

    private JPanel resultsPanel;

    private JComboBox<String> cityBox;
    private JComboBox<String> localityBox;
    private JComboBox<String> typeBox;
    private JComboBox<String> bhkBox;

    private JTextField minPriceField;
    private JTextField maxPriceField;

    private JLabel resultCountLabel;

    // =========================
    // COLORS
    // =========================

    private final Color BACKGROUND = new Color(16, 24, 39);
    private final Color PANEL = new Color(27, 38, 57);
    private final Color CARD = new Color(255, 253, 247);

    private final Color GOLD = new Color(212, 167, 44);

    private final Color TEXT = new Color(35, 42, 52);
    private final Color LIGHT_TEXT = new Color(225, 230, 237);

    public DashboardFrame() {

        // =========================
        // FRAME
        // =========================

        setTitle("SmartEstate");
        setSize(1200, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        getContentPane().setBackground(BACKGROUND);

        // ============================================================
        // HEADER
        // ============================================================

        JPanel header = new JPanel(new BorderLayout());

        header.setBackground(BACKGROUND);

        header.setBorder(
                new EmptyBorder(20, 30, 20, 30)
        );

        // -------------------------
        // BRAND
        // -------------------------

        JPanel brandPanel = new JPanel();

        brandPanel.setLayout(
                new BoxLayout(
                        brandPanel,
                        BoxLayout.Y_AXIS
                )
        );

        brandPanel.setOpaque(false);

        JLabel logo = new JLabel("🏠  SMARTESTATE");

        logo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28
                )
        );

        logo.setForeground(GOLD);

        JLabel tagline =
                new JLabel(
                        "Find. Compare. Shortlist. Decide."
                );

        tagline.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        13
                )
        );

        tagline.setForeground(LIGHT_TEXT);

        brandPanel.add(logo);

        brandPanel.add(
                Box.createVerticalStrut(4)
        );

        brandPanel.add(tagline);

        header.add(
                brandPanel,
                BorderLayout.WEST
        );

        // -------------------------
        // WELCOME
        // -------------------------

        JLabel welcome =
                new JLabel(
                        "Welcome to SmartEstate  👤"
                );

        welcome.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        welcome.setForeground(LIGHT_TEXT);

        header.add(
                welcome,
                BorderLayout.EAST
        );

        add(
                header,
                BorderLayout.NORTH
        );

        // ============================================================
        // MAIN PANEL
        // ============================================================

        JPanel mainPanel =
                new JPanel(
                        new BorderLayout(20, 20)
                );

        mainPanel.setBackground(BACKGROUND);

        mainPanel.setBorder(
                new EmptyBorder(
                        0,
                        30,
                        15,
                        30
                )
        );

        // ============================================================
        // SEARCH CONTAINER
        // ============================================================

        JPanel searchContainer =
                new JPanel(
                        new BorderLayout(0, 12)
                );

        searchContainer.setBackground(PANEL);

        searchContainer.setBorder(
                new EmptyBorder(
                        18,
                        20,
                        18,
                        20
                )
        );

        // -------------------------
        // SEARCH TITLE
        // -------------------------

        JLabel searchTitle =
                new JLabel(
                        "Find Your Perfect Property"
                );

        searchTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20
                )
        );

        searchTitle.setForeground(Color.WHITE);

        searchContainer.add(
                searchTitle,
                BorderLayout.NORTH
        );

        // ============================================================
        // SEARCH FORM
        // ============================================================

        JPanel searchPanel =
                new JPanel(
                        new GridLayout(
                                2,
                                7,
                                10,
                                8
                        )
                );

        searchPanel.setBackground(PANEL);

        // -------------------------
        // LABELS
        // -------------------------

        searchPanel.add(
                createLabel("CITY")
        );

        searchPanel.add(
                createLabel("LOCALITY")
        );

        searchPanel.add(
                createLabel("MIN PRICE")
        );

        searchPanel.add(
                createLabel("MAX PRICE")
        );

        searchPanel.add(
                createLabel("PROPERTY TYPE")
        );

        searchPanel.add(
                createLabel("BHK")
        );

        searchPanel.add(
                new JLabel("")
        );

        // ============================================================
        // INPUTS
        // ============================================================

        cityBox =
                new JComboBox<>(
                        new String[]{
                                "Jaipur"
                        }
                );

        localityBox =
                new JComboBox<>(
                        new String[]{
                                "All",
                                "Vaishali Nagar",
                                "Mansarovar",
                                "Malviya Nagar",
                                "Jagatpura",
                                "C-Scheme",
                                "Raja Park",
                                "Tonk Road"
                        }
                );

        minPriceField =
                new JTextField();

        maxPriceField =
                new JTextField();

        typeBox =
                new JComboBox<>(
                        new String[]{
                                "All",
                                "Apartment",
                                "Villa",
                                "House"
                        }
                );

        bhkBox =
                new JComboBox<>(
                        new String[]{
                                "All",
                                "1",
                                "2",
                                "3",
                                "4"
                        }
                );

        // ============================================================
        // STYLE INPUTS
        // ============================================================

        styleCombo(cityBox);

        styleCombo(localityBox);

        styleCombo(typeBox);

        styleCombo(bhkBox);

        styleTextField(minPriceField);

        styleTextField(maxPriceField);

        // ============================================================
        // ADD INPUTS
        // ============================================================

        searchPanel.add(cityBox);

        searchPanel.add(localityBox);

        searchPanel.add(minPriceField);

        searchPanel.add(maxPriceField);

        searchPanel.add(typeBox);

        searchPanel.add(bhkBox);

        // ============================================================
        // SEARCH BUTTON
        // ============================================================

        JButton searchButton =
                new JButton("SEARCH");

        searchButton.setPreferredSize(
                new Dimension(
                        130,
                        42
                )
        );

        styleButton(
                searchButton,
                GOLD,
                TEXT
        );

        searchButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        searchPanel.add(searchButton);

        searchContainer.add(
                searchPanel,
                BorderLayout.CENTER
        );

        mainPanel.add(
                searchContainer,
                BorderLayout.NORTH
        );

        // ============================================================
        // RESULT AREA
        // ============================================================

        JPanel resultArea =
                new JPanel(
                        new BorderLayout(
                                0,
                                10
                        )
                );

        resultArea.setOpaque(false);

        // ============================================================
        // RESULT HEADER
        // ============================================================

        JPanel resultHeader =
                new JPanel(
                        new BorderLayout()
                );

        resultHeader.setOpaque(false);

        JLabel propertiesTitle =
                new JLabel(
                        "Available Properties"
                );

        propertiesTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        21
                )
        );

        propertiesTitle.setForeground(
                Color.WHITE
        );

        resultCountLabel =
                new JLabel(
                        "Search using the filters above"
                );

        resultCountLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        13
                )
        );

        resultCountLabel.setForeground(
                LIGHT_TEXT
        );

        resultHeader.add(
                propertiesTitle,
                BorderLayout.WEST
        );

        resultHeader.add(
                resultCountLabel,
                BorderLayout.EAST
        );

        resultArea.add(
                resultHeader,
                BorderLayout.NORTH
        );

        // ============================================================
        // PROPERTY RESULTS
        // ============================================================

        resultsPanel =
                new JPanel(
                        new GridLayout(
                                0,
                                2,
                                18,
                                18
                        )
                );

        resultsPanel.setBackground(
                BACKGROUND
        );

        JScrollPane scrollPane =
                new JScrollPane(
                        resultsPanel
                );

        scrollPane.setBorder(null);

        scrollPane.setBackground(
                BACKGROUND
        );

        scrollPane
                .getViewport()
                .setBackground(
                        BACKGROUND
                );

        scrollPane
                .getVerticalScrollBar()
                .setUnitIncrement(18);

        resultArea.add(
                scrollPane,
                BorderLayout.CENTER
        );

        mainPanel.add(
                resultArea,
                BorderLayout.CENTER
        );

        add(
                mainPanel,
                BorderLayout.CENTER
        );

        // ============================================================
        // FOOTER
        // ============================================================

        JLabel footer =
                new JLabel(
                        "SmartEstate  •  Real Estate Property Listing & Management System",
                        SwingConstants.CENTER
                );

        footer.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        12
                )
        );

        footer.setForeground(
                new Color(
                        170,
                        178,
                        190
                )
        );

        footer.setBorder(
                new EmptyBorder(
                        8,
                        5,
                        10,
                        5
                )
        );

        add(
                footer,
                BorderLayout.SOUTH
        );

        // ============================================================
        // SEARCH ACTION
        // ============================================================

        searchButton.addActionListener(
                e -> searchProperties()
        );

        // ============================================================
        // SHOW WINDOW
        // ============================================================

        setVisible(true);
    }

    // ================================================================
    // SEARCH PROPERTIES
    // ================================================================

    private void searchProperties() {

        try {

            String city =
                    (String) cityBox.getSelectedItem();

            String locality =
                    (String) localityBox.getSelectedItem();

            String propertyType =
                    (String) typeBox.getSelectedItem();

            // -------------------------
            // PRICE
            // -------------------------

            String minText =
                    minPriceField
                            .getText()
                            .trim()
                            .replace("₹", "")
                            .replace(",", "");

            String maxText =
                    maxPriceField
                            .getText()
                            .trim()
                            .replace("₹", "")
                            .replace(",", "");

            double minPrice =
                    Double.parseDouble(
                            minText
                    );

            double maxPrice =
                    Double.parseDouble(
                            maxText
                    );

            // -------------------------
            // VALIDATE PRICE
            // -------------------------

            if (minPrice > maxPrice) {

                JOptionPane.showMessageDialog(
                        this,
                        "Minimum price cannot be greater than maximum price.",
                        "Invalid Price Range",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            // -------------------------
            // BHK
            // -------------------------

            String bhkText =
                    (String) bhkBox.getSelectedItem();

            int bhk =
                    bhkText.equals("All")
                            ? 0
                            : Integer.parseInt(
                                    bhkText
                            );

            // ========================================================
            // DATABASE SEARCH
            // ========================================================

            PropertyDAO dao =
                    new PropertyDAO();

            List<Property> properties =
                    dao.searchProperties(
                            city,
                            locality,
                            minPrice,
                            maxPrice,
                            propertyType,
                            bhk
                    );

            // ========================================================
            // CLEAR OLD RESULTS
            // ========================================================

            resultsPanel.removeAll();

            // ========================================================
            // RESULT COUNT
            // ========================================================

            resultCountLabel.setText(
                    properties.size()
                            + " properties found"
            );

            // ========================================================
            // NO RESULTS
            // ========================================================

            if (properties.isEmpty()) {

                JLabel noResults =
                        new JLabel(
                                "No properties found.",
                                SwingConstants.CENTER
                        );

                noResults.setFont(
                        new Font(
                                "Arial",
                                Font.BOLD,
                                20
                        )
                );

                noResults.setForeground(
                        Color.WHITE
                );

                resultsPanel.add(
                        noResults
                );

            }

            // ========================================================
            // SHOW PROPERTY CARDS
            // ========================================================

            else {

                for (Property property : properties) {

                    resultsPanel.add(
                            createPropertyCard(
                                    property
                            )
                    );
                }
            }

            resultsPanel.revalidate();

            resultsPanel.repaint();

        }

        // ============================================================
        // INVALID NUMBER
        // ============================================================

        catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid price values.\n\n"
                            + "Example: 3000000",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        // ============================================================
        // OTHER ERROR
        // ============================================================

        catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Something went wrong:\n"
                            + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            ex.printStackTrace();
        }
    }

    // ================================================================
    // PROPERTY CARD
    // ================================================================

    private JPanel createPropertyCard(
            Property property
    ) {

        JPanel card =
                new JPanel();

        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS
                )
        );

        card.setBackground(
                CARD
        );

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                GOLD,
                                1
                        ),
                        new EmptyBorder(
                                18,
                                18,
                                18,
                                18
                        )
                )
        );

        // ============================================================
        // PROPERTY TYPE
        // ============================================================

        JLabel type =
                new JLabel(
                        property
                                .getPropertyType()
                                .toUpperCase()
                );

        type.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        11
                )
        );

        type.setForeground(
                new Color(
                        120,
                        90,
                        15
                )
        );

        // ============================================================
        // TITLE
        // ============================================================

        JLabel title =
                new JLabel(
                        property.getTitle()
                );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        title.setForeground(
                TEXT
        );

        // ============================================================
        // PRICE
        // ============================================================

        JLabel price =
                new JLabel(
                        "₹"
                                + String.format(
                                        "%,.0f",
                                        property.getPrice()
                                )
                );

        price.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        price.setForeground(
                new Color(
                        24,
                        110,
                        78
                )
        );

        // ============================================================
        // DETAILS
        // ============================================================

        JLabel details =
                new JLabel(
                        property.getBhk()
                                + " BHK   •   "
                                + property.getAreaSqft()
                                + " sq.ft."
                );

        details.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        details.setForeground(
                new Color(
                        80,
                        85,
                        90
                )
        );

        // ============================================================
        // LOCATION
        // ============================================================

        JLabel location =
                new JLabel(
                        "📍 "
                                + property.getLocality()
                                + ", "
                                + property.getCity()
                );

        location.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        location.setForeground(
                new Color(
                        80,
                        85,
                        90
                )
        );

        // ============================================================
        // BUTTONS
        // ============================================================

        JButton detailsButton =
                new JButton(
                        "VIEW DETAILS"
                );

        JButton shortlistButton =
                new JButton(
                        "♡ SHORTLIST"
                );

        detailsButton.setPreferredSize(
                new Dimension(
                        135,
                        38
                )
        );

        shortlistButton.setPreferredSize(
                new Dimension(
                        135,
                        38
                )
        );

        // ============================================================
        // BUTTON STYLING
        // ============================================================

        styleButton(
                detailsButton,
                BACKGROUND,
                Color.WHITE
        );

        styleButton(
                shortlistButton,
                GOLD,
                TEXT
        );

        // ============================================================
        // VIEW DETAILS ACTION
        // ============================================================

        detailsButton.addActionListener(
                e -> {

                    JOptionPane.showMessageDialog(
                            this,

                            "PROPERTY DETAILS\n\n"

                                    + "Title: "
                                    + property.getTitle()

                                    + "\n\nPrice: ₹"
                                    + String.format(
                                            "%,.0f",
                                            property.getPrice()
                                    )

                                    + "\n\nType: "
                                    + property.getPropertyType()

                                    + "\nBHK: "
                                    + property.getBhk()

                                    + "\nArea: "
                                    + property.getAreaSqft()
                                    + " sq.ft."

                                    + "\n\nLocation: "
                                    + property.getLocality()
                                    + ", "
                                    + property.getCity()

                                    + "\n\nAddress: "
                                    + property.getAddress()

                                    + "\n\nOwner: "
                                    + property.getOwnerName()

                                    + "\nPhone: "
                                    + property.getOwnerPhone(),

                            "Property Details",

                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
        );

        // ============================================================
        // SHORTLIST ACTION
        // ============================================================

        shortlistButton.addActionListener(
                e -> {

                    JOptionPane.showMessageDialog(
                            this,

                            "❤️ "
                                    + property.getTitle()
                                    + "\n\nAdded to shortlist!",

                            "Shortlist",

                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
        );

        // ============================================================
        // BUTTON PANEL
        // ============================================================

        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT,
                                8,
                                0
                        )
                );

        buttonPanel.setOpaque(false);

        buttonPanel.add(
                detailsButton
        );

        buttonPanel.add(
                shortlistButton
        );

        // ============================================================
        // ADD COMPONENTS TO CARD
        // ============================================================

        card.add(type);

        card.add(
                Box.createVerticalStrut(7)
        );

        card.add(title);

        card.add(
                Box.createVerticalStrut(10)
        );

        card.add(price);

        card.add(
                Box.createVerticalStrut(8)
        );

        card.add(details);

        card.add(
                Box.createVerticalStrut(6)
        );

        card.add(location);

        card.add(
                Box.createVerticalStrut(18)
        );

        card.add(buttonPanel);

        return card;
    }

    // ================================================================
    // UNIVERSAL BUTTON STYLE
    // ================================================================

    private void styleButton(
            JButton button,
            Color background,
            Color foreground
    ) {

        /*
         * IMPORTANT:
         * BasicButtonUI prevents macOS Aqua
         * from overriding our button colors.
         */

        button.setUI(
                new BasicButtonUI()
        );

        button.setBackground(
                background
        );

        button.setForeground(
                foreground
        );

        button.setOpaque(true);

        button.setContentAreaFilled(true);

        button.setBorderPainted(false);

        button.setFocusPainted(false);

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        12
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );
    }

    // ================================================================
    // COMBO BOX STYLE
    // ================================================================

    private void styleCombo(
            JComboBox<String> combo
    ) {

        combo.setBackground(
                Color.WHITE
        );

        combo.setForeground(
                TEXT
        );

        combo.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        13
                )
        );

        combo.setPreferredSize(
                new Dimension(
                        140,
                        38
                )
        );
    }

    // ================================================================
    // TEXT FIELD STYLE
    // ================================================================

    private void styleTextField(
            JTextField field
    ) {

        field.setBackground(
                Color.WHITE
        );

        field.setForeground(
                TEXT
        );

        field.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        13
                )
        );

        field.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        210,
                                        210,
                                        210
                                )
                        ),
                        new EmptyBorder(
                                5,
                                8,
                                5,
                                8
                        )
                )
        );

        field.setPreferredSize(
                new Dimension(
                        120,
                        38
                )
        );
    }

    // ================================================================
    // LABEL CREATOR
    // ================================================================

    private JLabel createLabel(
            String text
    ) {

        JLabel label =
                new JLabel(
                        text
                );

        label.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        11
                )
        );

        label.setForeground(
                new Color(
                        190,
                        198,
                        210
                )
        );

        return label;
    }
}