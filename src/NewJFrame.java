
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class NewJFrame extends javax.swing.JFrame {
    // Constant
    private static final String[] COLUMN_TABLE_SINH_VIEN = {"id", "Họ tên", "Giới tính", "Ngày sinh", "Điện thoại", "MSV", "Lớp"};
    private static final String[] COLUMN_TABLE_LICH_SU_GUI_XE = {"id", "Họ tên", "MSV", "Biển số", "Màu sắc", "Thời gian", "Trạng thái"};
    private static final String[] COLUMN_TABLE_SACH_THU_VIEN = {"Mã sách", "Tên sách", "Trạng thái"};
    private static final String[] COLUMN_TABLE_LICH_SU_MUON_SACH = {"Mã sách", "Tên sách", "Trạng thái", "Thời gian", "Sinh viên"};
    private static final String[] COLUMN_TABLE_SACH_DANG_MUON = {"Mã sách", "Tên sách"};
    
    private static final String MAIN_CARD_NAME = "card6";
    // admin function
    private static final String CREATE_PIN_NAME = "card3";
    private static final String EDIT_INFO_NAME = "card4";
    // sv function
    private static final String SV_CARD_NAME = "card9";
    private static final String CHANGE_PIN_CARD_NAME = "card4";
    // gui xe function
    private static final String GUI_XE_FUNCTION_CARD_NAME = "card7";
    private static final String GUI_XE_CARD_NAME = "card3";
    private static final String LICH_SU_GUI_XE_CARD_NAME = "card2";
    // thu vien function
    private static final String THU_VIEN_CARD_NAME = "card8";
    private static final String SACH_THU_VIEN_CARD_NAME = "card2";
    private static final String LICH_SU_SACH_CARD_NAME = "card3";
    private static final String MUON_SACH_CARD_NAME = "card4";
    private static final String TRA_SACH_CARD_NAME = "card5";
    
    // SV function var
    private Object[][] sinhvienData = {};
    private DefaultTableModel sinhvienTableModel;
    // GuiXe Function var
    private Object[][] guiXeData = {};
    private DefaultTableModel guiXeTableModel;
    // Thu vien var
    private Object[][] sachData = {};
    private DefaultTableModel sachTableModel;
    private Object[][] lichSuSachData = {};
    private DefaultTableModel lichSuSachTableModel;
    private Object[][] muonSachData = {};
    private DefaultTableModel muonSachTableModel;
    private Object[][] sachDangMuonData = {};
    private DefaultTableModel sachDangMuonTableModel;
    
    // GUI component
    private SmartCardWord smartCardWord;
    private CardLayout cardLayout;
    private CardLayout adminCardLayout;
    private CardLayout guiXeCardLayout;
    private CardLayout thuVienCardLayout;
    private CardLayout svCardLayout;

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        setSize(900, 600);
        setTitle("Java Card OS");
        setResizable(false);
        
        initComponents();
        
        smartCardWord = new SmartCardWord();
        cardLayout = (CardLayout) parentPanel.getLayout();
        adminCardLayout = (CardLayout) panelAdminContainer.getLayout();
        guiXeCardLayout = (CardLayout) panelGuiXeContainer.getLayout();
        thuVienCardLayout = (CardLayout) panelThuVienContainer.getLayout();
        svCardLayout = (CardLayout) panelSVContainer.getLayout();
        
        // KHoi tao bang de truyen thong tin sinh vien
        sinhvienTableModel = new DefaultTableModel(sinhvienData, COLUMN_TABLE_SINH_VIEN);
        tableSinhVien.setModel(sinhvienTableModel);
        // Khoi tao bang de truyen thong tin lich su gui xe
        guiXeTableModel = new DefaultTableModel(guiXeData, COLUMN_TABLE_LICH_SU_GUI_XE);
        tableLichSuGuiXe.setModel(guiXeTableModel);
        // Khoi tao bang cho chuc nang thu vien
        sachTableModel = new DefaultTableModel(sachData, COLUMN_TABLE_SACH_THU_VIEN);
        tableSach.setModel(sachTableModel);
        lichSuSachTableModel = new DefaultTableModel(lichSuSachData, COLUMN_TABLE_LICH_SU_MUON_SACH);
        tableLichSuSach.setModel(lichSuSachTableModel);
        muonSachTableModel = new DefaultTableModel(muonSachData, COLUMN_TABLE_SACH_THU_VIEN);
        tableMuonSach.setModel(muonSachTableModel);
        sachDangMuonTableModel = new DefaultTableModel(sachDangMuonData, COLUMN_TABLE_SACH_DANG_MUON);
        tableSachDangMuon.setModel(sachDangMuonTableModel);
        
        // set false cho viec resize lai bang
        tableLichSuGuiXe.getTableHeader().setReorderingAllowed(false);
        tableLichSuSach.getTableHeader().setReorderingAllowed(false);
        tableMuonSach.getTableHeader().setReorderingAllowed(false);
        tableSach.getTableHeader().setReorderingAllowed(false);
        tableSachDangMuon.getTableHeader().setReorderingAllowed(false);
        tableSinhVien.getTableHeader().setReorderingAllowed(false);
        //
        tableLichSuGuiXe.getTableHeader().setResizingAllowed(false);
        tableLichSuSach.getTableHeader().setResizingAllowed(false);
        tableMuonSach.getTableHeader().setResizingAllowed(false);
        tableSach.getTableHeader().setResizingAllowed(false);
        tableSachDangMuon.getTableHeader().setResizingAllowed(false);
        tableSinhVien.getTableHeader().setResizingAllowed(false);
        
        setBackgroundColor();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        parentPanel = new javax.swing.JPanel();
        panelMain = new javax.swing.JPanel();
        buttonConnect = new javax.swing.JButton();
        buttionAdminFunction = new javax.swing.JButton();
        buttonGuiXeFunction = new javax.swing.JButton();
        buttonThuVienFunction = new javax.swing.JButton();
        panelCardStatus = new javax.swing.JPanel();
        labelCardStatus = new javax.swing.JLabel();
        buttonSVFunction = new javax.swing.JButton();
        panelAdminFunction = new javax.swing.JPanel();
        buttonEditÌno = new javax.swing.JButton();
        backButton2 = new javax.swing.JButton();
        buttonUnlockCard = new javax.swing.JButton();
        buttonFlushInfoCard = new javax.swing.JButton();
        buttonCleanInfo = new javax.swing.JButton();
        panelAdminContainer = new javax.swing.JPanel();
        panelUnlockCard = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        unlockCardTextField = new javax.swing.JTextField();
        unlockButton = new javax.swing.JButton();
        panelFlushInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        createPinButton = new javax.swing.JButton();
        pinTextField = new javax.swing.JPasswordField();
        pinConfirmTextField = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSinhVien = new javax.swing.JTable();
        panelEditInfo = new javax.swing.JPanel();
        labelAvatarSV = new javax.swing.JLabel();
        buttonChooseAvatar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        textFileldEditNameSV = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        rButtonGenderMale = new javax.swing.JRadioButton();
        rButtonGenderFemale = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cb_ThangSinhSV = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        cb_NgaySinhSV = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        cb_NamSinhSV = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        tf_SoDienThoaiSV = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tf_Masinhvien = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cb_LopSV = new javax.swing.JTextField();
        b_Updateinfo = new javax.swing.JButton();
        panelCleanInfo = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        textFieldPinCleanInfo = new javax.swing.JTextField();
        buttonResetInfo = new javax.swing.JButton();
        panelGuiXeFunction = new javax.swing.JPanel();
        backButton3 = new javax.swing.JButton();
        buttonLichSuGuiXe = new javax.swing.JButton();
        buttonGuiXeTab = new javax.swing.JButton();
        panelGuiXeContainer = new javax.swing.JPanel();
        panelLichSuGuiXe = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableLichSuGuiXe = new javax.swing.JTable();
        panelGuiXe = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        labelHangXe = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        labelMauSacXe = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        labelBienSoXe = new javax.swing.JLabel();
        buttonCheckXe = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        labelTrangThaiXe = new javax.swing.JLabel();
        panelThuVienFunction = new javax.swing.JPanel();
        backButton4 = new javax.swing.JButton();
        buttonListSach = new javax.swing.JButton();
        buttonLichSuSach = new javax.swing.JButton();
        buttonMuonSach = new javax.swing.JButton();
        buttonTraSach = new javax.swing.JButton();
        panelThuVienContainer = new javax.swing.JPanel();
        panelSachThuVien = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableSach = new javax.swing.JTable();
        textFieldTimKiemS = new javax.swing.JTextField();
        buttonTimKiemS = new javax.swing.JButton();
        panelLichSuSach = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableLichSuSach = new javax.swing.JTable();
        textFieldTimKiemLS = new javax.swing.JTextField();
        buttonTimKiemLS = new javax.swing.JButton();
        panelMuonSach = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableMuonSach = new javax.swing.JTable();
        buttonDoMuonSach = new javax.swing.JButton();
        textFieldTimKiemMS = new javax.swing.JTextField();
        buttonTimKiemMS = new javax.swing.JButton();
        panelTraSach = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        labelHoTenTraSach = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        labelMSVTraSach = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableSachDangMuon = new javax.swing.JTable();
        buttonDoTraSach = new javax.swing.JButton();
        panelSVFunction = new javax.swing.JPanel();
        backButton5 = new javax.swing.JButton();
        panelSVContainer = new javax.swing.JPanel();
        panelChangePin = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        oldPinTextField = new javax.swing.JPasswordField();
        newPinTextField = new javax.swing.JPasswordField();
        newPinConfirmTextField = new javax.swing.JPasswordField();
        openChangePinButtion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        parentPanel.setLayout(new java.awt.CardLayout());

        buttonConnect.setText("Connect");
        buttonConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectCard(evt);
            }
        });

        buttionAdminFunction.setText("Chức năng Admin");
        buttionAdminFunction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminFunction(evt);
            }
        });

        buttonGuiXeFunction.setText("Gửi xe");
        buttonGuiXeFunction.setPreferredSize(new java.awt.Dimension(133, 25));
        buttonGuiXeFunction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openGuiXeFunction(evt);
            }
        });

        buttonThuVienFunction.setText("Thư viện");
        buttonThuVienFunction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openThuVienFunction(evt);
            }
        });

        javax.swing.GroupLayout panelCardStatusLayout = new javax.swing.GroupLayout(panelCardStatus);
        panelCardStatus.setLayout(panelCardStatusLayout);
        panelCardStatusLayout.setHorizontalGroup(
            panelCardStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        panelCardStatusLayout.setVerticalGroup(
            panelCardStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        labelCardStatus.setText("Card disconnected");

        buttonSVFunction.setText("Sinh viên");
        buttonSVFunction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openSVFunction(evt);
            }
        });

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelCardStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelCardStatus))
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonSVFunction, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonThuVienFunction, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(buttionAdminFunction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonConnect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonGuiXeFunction, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(323, Short.MAX_VALUE))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addContainerGap(174, Short.MAX_VALUE)
                .addComponent(buttonConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttionAdminFunction, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonGuiXeFunction, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonThuVienFunction, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonSVFunction, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelCardStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCardStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addContainerGap())
        );

        parentPanel.add(panelMain, "card6");

        buttonEditÌno.setText("Sửa thông tin");
        buttonEditÌno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openEditFunction(evt);
            }
        });

        backButton2.setText("Back");
        backButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToEntry(evt);
            }
        });

        buttonUnlockCard.setText("Mở khóa thẻ");
        buttonUnlockCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openUnlockTab(evt);
            }
        });

        buttonFlushInfoCard.setText("Nạp thông tin ");
        buttonFlushInfoCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openCreatePinPanel(evt);
            }
        });

        buttonCleanInfo.setText("Reset thẻ");

        panelAdminContainer.setForeground(new java.awt.Color(153, 255, 0));
        panelAdminContainer.setLayout(new java.awt.CardLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("MỞ KHÓA THẺ");

        jLabel9.setText("Nhập mật khẩu mở khóa:");

        unlockButton.setText("Mở khóa");
        unlockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unlockCard(evt);
            }
        });

        javax.swing.GroupLayout panelUnlockCardLayout = new javax.swing.GroupLayout(panelUnlockCard);
        panelUnlockCard.setLayout(panelUnlockCardLayout);
        panelUnlockCardLayout.setHorizontalGroup(
            panelUnlockCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUnlockCardLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(unlockCardTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUnlockCardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelUnlockCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUnlockCardLayout.createSequentialGroup()
                        .addComponent(unlockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(312, 312, 312))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUnlockCardLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(303, 303, 303))))
        );
        panelUnlockCardLayout.setVerticalGroup(
            panelUnlockCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUnlockCardLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
                .addGroup(panelUnlockCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unlockCardTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(42, 42, 42)
                .addComponent(unlockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(238, Short.MAX_VALUE))
        );

        panelAdminContainer.add(panelUnlockCard, "card2");

        panelFlushInfo.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("NẠP THÔNG TIN THẺ");

        jLabel2.setText("Nhập PIN:");

        jLabel3.setText("Nhập lại PIN:");

        createPinButton.setText("Xác nhận");
        createPinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPin(evt);
            }
        });

        tableSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableSinhVien);

        javax.swing.GroupLayout panelFlushInfoLayout = new javax.swing.GroupLayout(panelFlushInfo);
        panelFlushInfo.setLayout(panelFlushInfoLayout);
        panelFlushInfoLayout.setHorizontalGroup(
            panelFlushInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFlushInfoLayout.createSequentialGroup()
                .addGroup(panelFlushInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFlushInfoLayout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(createPinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 315, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFlushInfoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelFlushInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(panelFlushInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pinTextField)
                            .addComponent(pinConfirmTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelFlushInfoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelFlushInfoLayout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelFlushInfoLayout.setVerticalGroup(
            panelFlushInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFlushInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelFlushInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pinTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFlushInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pinConfirmTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(createPinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelAdminContainer.add(panelFlushInfo, "card3");

        buttonChooseAvatar.setText("Chọn ảnh");

        jLabel10.setText("Họ tên:");

        jLabel11.setText("Giới tính:");

        rButtonGenderMale.setText("Nam");

        rButtonGenderFemale.setText("Nữ");

        jLabel12.setText("Ngày sinh:");

        jLabel13.setText("Tháng");

        cb_ThangSinhSV.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setText("Ngày");

        cb_NgaySinhSV.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setText("Năm");

        cb_NamSinhSV.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel16.setText("Số điện thoại:");

        jLabel17.setText("Mã sinh viên:");

        jLabel18.setText("Lớp:");

        b_Updateinfo.setText("Cập nhật");

        javax.swing.GroupLayout panelEditInfoLayout = new javax.swing.GroupLayout(panelEditInfo);
        panelEditInfo.setLayout(panelEditInfoLayout);
        panelEditInfoLayout.setHorizontalGroup(
            panelEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditInfoLayout.createSequentialGroup()
                .addGroup(panelEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditInfoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelAvatarSV, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEditInfoLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(buttonChooseAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFileldEditNameSV)
                    .addComponent(tf_SoDienThoaiSV)
                    .addComponent(tf_Masinhvien)
                    .addGroup(panelEditInfoLayout.createSequentialGroup()
                        .addGroup(panelEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addGroup(panelEditInfoLayout.createSequentialGroup()
                                .addComponent(rButtonGenderMale)
                                .addGap(18, 18, 18)
                                .addComponent(rButtonGenderFemale))
                            .addComponent(jLabel12)
                            .addGroup(panelEditInfoLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_ThangSinhSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_NgaySinhSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_NamSinhSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel16))
                        .addGap(0, 170, Short.MAX_VALUE))
                    .addComponent(cb_LopSV))
                .addContainerGap())
            .addGroup(panelEditInfoLayout.createSequentialGroup()
                .addGap(307, 307, 307)
                .addComponent(b_Updateinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelEditInfoLayout.setVerticalGroup(
            panelEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditInfoLayout.createSequentialGroup()
                        .addComponent(labelAvatarSV, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonChooseAvatar))
                    .addGroup(panelEditInfoLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFileldEditNameSV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGap(9, 9, 9)
                        .addGroup(panelEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rButtonGenderMale)
                            .addComponent(rButtonGenderFemale))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelEditInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cb_ThangSinhSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(cb_NgaySinhSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(cb_NamSinhSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_SoDienThoaiSV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_Masinhvien, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_LopSV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(b_Updateinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        panelAdminContainer.add(panelEditInfo, "card4");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("RESET DỮ LIỆU THẺ");

        jLabel20.setText("Nhập mật khẩu mở khóa:");

        buttonResetInfo.setText("Reset");
        buttonResetInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetInfounlockCard(evt);
            }
        });

        javax.swing.GroupLayout panelCleanInfoLayout = new javax.swing.GroupLayout(panelCleanInfo);
        panelCleanInfo.setLayout(panelCleanInfoLayout);
        panelCleanInfoLayout.setHorizontalGroup(
            panelCleanInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCleanInfoLayout.createSequentialGroup()
                .addGroup(panelCleanInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCleanInfoLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(panelCleanInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelCleanInfoLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(textFieldPinCleanInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCleanInfoLayout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(buttonResetInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(287, Short.MAX_VALUE))
        );
        panelCleanInfoLayout.setVerticalGroup(
            panelCleanInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCleanInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(panelCleanInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldPinCleanInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
                .addComponent(buttonResetInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
        );

        panelAdminContainer.add(panelCleanInfo, "card5");

        javax.swing.GroupLayout panelAdminFunctionLayout = new javax.swing.GroupLayout(panelAdminFunction);
        panelAdminFunction.setLayout(panelAdminFunctionLayout);
        panelAdminFunctionLayout.setHorizontalGroup(
            panelAdminFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminFunctionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAdminFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAdminFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(buttonUnlockCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonFlushInfoCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonEditÌno, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonCleanInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(775, Short.MAX_VALUE))
            .addGroup(panelAdminFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelAdminFunctionLayout.createSequentialGroup()
                    .addGap(134, 134, 134)
                    .addComponent(panelAdminContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelAdminFunctionLayout.setVerticalGroup(
            panelAdminFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdminFunctionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonUnlockCard, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonFlushInfoCard, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonEditÌno, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonCleanInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 309, Short.MAX_VALUE)
                .addComponent(backButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panelAdminFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelAdminFunctionLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelAdminContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 574, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        parentPanel.add(panelAdminFunction, "card5");

        backButton3.setText("Back");
        backButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToEntry(evt);
            }
        });

        buttonLichSuGuiXe.setText("Lịch sử");
        buttonLichSuGuiXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openLichSuGuiXeTab(evt);
            }
        });

        buttonGuiXeTab.setText("Gửi xe");
        buttonGuiXeTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openGuiXeTab(evt);
            }
        });

        panelGuiXeContainer.setLayout(new java.awt.CardLayout());

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("LỊCH SỬ GỬI XE");

        tableLichSuGuiXe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableLichSuGuiXe);

        javax.swing.GroupLayout panelLichSuGuiXeLayout = new javax.swing.GroupLayout(panelLichSuGuiXe);
        panelLichSuGuiXe.setLayout(panelLichSuGuiXeLayout);
        panelLichSuGuiXeLayout.setHorizontalGroup(
            panelLichSuGuiXeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLichSuGuiXeLayout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelLichSuGuiXeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelLichSuGuiXeLayout.setVerticalGroup(
            panelLichSuGuiXeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLichSuGuiXeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        panelGuiXeContainer.add(panelLichSuGuiXe, "card2");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("GỬI XE");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel23.setText("Thông tin xe:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel24.setText("Hãng xe:");

        labelHangXe.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelHangXe.setText("Wave");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel25.setText("Màu sắc:");

        labelMauSacXe.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelMauSacXe.setText("Wave");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel26.setText("Biển số:");

        labelBienSoXe.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelBienSoXe.setText("Wave");

        buttonCheckXe.setText("Gửi xe");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel27.setText("Trạng thái:");

        labelTrangThaiXe.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelTrangThaiXe.setText("Wave");

        javax.swing.GroupLayout panelGuiXeLayout = new javax.swing.GroupLayout(panelGuiXe);
        panelGuiXe.setLayout(panelGuiXeLayout);
        panelGuiXeLayout.setHorizontalGroup(
            panelGuiXeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGuiXeLayout.createSequentialGroup()
                .addGroup(panelGuiXeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGuiXeLayout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelGuiXeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel23))
                    .addGroup(panelGuiXeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel24))
                    .addGroup(panelGuiXeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelGuiXeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)))
                    .addGroup(panelGuiXeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addGroup(panelGuiXeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelBienSoXe, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTrangThaiXe, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMauSacXe, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelHangXe, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelGuiXeLayout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(buttonCheckXe, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(323, Short.MAX_VALUE))
        );
        panelGuiXeLayout.setVerticalGroup(
            panelGuiXeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGuiXeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGuiXeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(labelHangXe))
                .addGap(18, 18, 18)
                .addGroup(panelGuiXeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(labelMauSacXe))
                .addGap(18, 18, 18)
                .addGroup(panelGuiXeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(labelBienSoXe))
                .addGap(18, 18, 18)
                .addGroup(panelGuiXeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(labelTrangThaiXe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
                .addComponent(buttonCheckXe, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelGuiXeContainer.add(panelGuiXe, "card3");

        javax.swing.GroupLayout panelGuiXeFunctionLayout = new javax.swing.GroupLayout(panelGuiXeFunction);
        panelGuiXeFunction.setLayout(panelGuiXeFunctionLayout);
        panelGuiXeFunctionLayout.setHorizontalGroup(
            panelGuiXeFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGuiXeFunctionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGuiXeFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(backButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(buttonLichSuGuiXe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonGuiXeTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGuiXeContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelGuiXeFunctionLayout.setVerticalGroup(
            panelGuiXeFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGuiXeFunctionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGuiXeFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelGuiXeContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelGuiXeFunctionLayout.createSequentialGroup()
                        .addComponent(buttonLichSuGuiXe, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonGuiXeTab, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        parentPanel.add(panelGuiXeFunction, "card7");

        backButton4.setText("Back");
        backButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToEntry(evt);
            }
        });

        buttonListSach.setText("Sách thư viện");
        buttonListSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openSachThuVienTab(evt);
            }
        });

        buttonLichSuSach.setText("Lịch sử mượn sách");
        buttonLichSuSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openLichSuSachTab(evt);
            }
        });

        buttonMuonSach.setText("Mượn sách");
        buttonMuonSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMuonSachTab(evt);
            }
        });

        buttonTraSach.setText("Trả sách");
        buttonTraSach.setToolTipText("");
        buttonTraSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openTraSachTab(evt);
            }
        });

        panelThuVienContainer.setLayout(new java.awt.CardLayout());

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("DỮ LIỆU SÁCH TRÊN THƯ VIỆN");

        tableSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tableSach);

        buttonTimKiemS.setText("Tìm kiếm");

        javax.swing.GroupLayout panelSachThuVienLayout = new javax.swing.GroupLayout(panelSachThuVien);
        panelSachThuVien.setLayout(panelSachThuVienLayout);
        panelSachThuVienLayout.setHorizontalGroup(
            panelSachThuVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSachThuVienLayout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSachThuVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSachThuVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSachThuVienLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(textFieldTimKiemS, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonTimKiemS, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelSachThuVienLayout.setVerticalGroup(
            panelSachThuVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSachThuVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addGroup(panelSachThuVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonTimKiemS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldTimKiemS, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelThuVienContainer.add(panelSachThuVien, "card2");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("LỊCH SỬ MƯỢN SÁCH THƯ VIỆN");

        tableLichSuSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tableLichSuSach);

        buttonTimKiemLS.setText("Tìm kiếm");

        javax.swing.GroupLayout panelLichSuSachLayout = new javax.swing.GroupLayout(panelLichSuSach);
        panelLichSuSach.setLayout(panelLichSuSachLayout);
        panelLichSuSachLayout.setHorizontalGroup(
            panelLichSuSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLichSuSachLayout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(235, Short.MAX_VALUE))
            .addGroup(panelLichSuSachLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLichSuSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLichSuSachLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(textFieldTimKiemLS, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonTimKiemLS, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelLichSuSachLayout.setVerticalGroup(
            panelLichSuSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLichSuSachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addGap(9, 9, 9)
                .addGroup(panelLichSuSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonTimKiemLS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldTimKiemLS, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelThuVienContainer.add(panelLichSuSach, "card3");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("MƯỢN SÁCH");

        tableMuonSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tableMuonSach);

        buttonDoMuonSach.setText("Mượn sách");

        buttonTimKiemMS.setText("Tìm kiếm");

        javax.swing.GroupLayout panelMuonSachLayout = new javax.swing.GroupLayout(panelMuonSach);
        panelMuonSach.setLayout(panelMuonSachLayout);
        panelMuonSachLayout.setHorizontalGroup(
            panelMuonSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMuonSachLayout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(buttonDoMuonSach, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelMuonSachLayout.createSequentialGroup()
                .addGroup(panelMuonSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMuonSachLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5))
                    .addGroup(panelMuonSachLayout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 224, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMuonSachLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textFieldTimKiemMS, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonTimKiemMS, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelMuonSachLayout.setVerticalGroup(
            panelMuonSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMuonSachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMuonSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonTimKiemMS, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(textFieldTimKiemMS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDoMuonSach, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelThuVienContainer.add(panelMuonSach, "card4");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("TRẢ SÁCH");

        labelHoTenTraSach.setText("Thông tin sinh viên:");

        jLabel33.setText("Họ tên:");

        jLabel34.setText("Mã SV:");

        jLabel35.setText("Thông tin sinh viên:");

        labelMSVTraSach.setText("Thông tin sinh viên:");

        tableSachDangMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tableSachDangMuon);

        buttonDoTraSach.setText("Trả sách");

        javax.swing.GroupLayout panelTraSachLayout = new javax.swing.GroupLayout(panelTraSach);
        panelTraSach.setLayout(panelTraSachLayout);
        panelTraSachLayout.setHorizontalGroup(
            panelTraSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTraSachLayout.createSequentialGroup()
                .addGroup(panelTraSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTraSachLayout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelTraSachLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(panelTraSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTraSachLayout.createSequentialGroup()
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelHoTenTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTraSachLayout.createSequentialGroup()
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelMSVTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelTraSachLayout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addComponent(buttonDoTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelTraSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelTraSachLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(582, Short.MAX_VALUE)))
        );
        panelTraSachLayout.setVerticalGroup(
            panelTraSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTraSachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addGroup(panelTraSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTraSachLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(panelTraSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelHoTenTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTraSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMSVTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelTraSachLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonDoTraSach, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelTraSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelTraSachLayout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(493, Short.MAX_VALUE)))
        );

        panelThuVienContainer.add(panelTraSach, "card5");

        javax.swing.GroupLayout panelThuVienFunctionLayout = new javax.swing.GroupLayout(panelThuVienFunction);
        panelThuVienFunction.setLayout(panelThuVienFunctionLayout);
        panelThuVienFunctionLayout.setHorizontalGroup(
            panelThuVienFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThuVienFunctionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelThuVienFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(backButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonListSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonLichSuSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonMuonSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonTraSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelThuVienContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelThuVienFunctionLayout.setVerticalGroup(
            panelThuVienFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelThuVienFunctionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelThuVienFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelThuVienContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelThuVienFunctionLayout.createSequentialGroup()
                        .addComponent(buttonListSach, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonLichSuSach, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonMuonSach, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        parentPanel.add(panelThuVienFunction, "card8");

        backButton5.setText("Back");
        backButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToEntry(evt);
            }
        });

        panelSVContainer.setLayout(new java.awt.CardLayout());

        panelChangePin.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("ĐỔI PIN CHO THẺ");

        jLabel5.setText("Nhập PIN:");

        jLabel6.setText("Nhập lại PIN:");

        jLabel7.setText("Nhập PIN cũ:");

        confirmButton.setText("Xác nhận");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmChangePin(evt);
            }
        });

        javax.swing.GroupLayout panelChangePinLayout = new javax.swing.GroupLayout(panelChangePin);
        panelChangePin.setLayout(panelChangePinLayout);
        panelChangePinLayout.setHorizontalGroup(
            panelChangePinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelChangePinLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelChangePinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelChangePinLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(307, 307, 307))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelChangePinLayout.createSequentialGroup()
                        .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(336, 336, 336))))
            .addGroup(panelChangePinLayout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addGroup(panelChangePinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(panelChangePinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newPinTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(oldPinTextField)
                    .addComponent(newPinConfirmTextField))
                .addGap(288, 288, 288))
        );
        panelChangePinLayout.setVerticalGroup(
            panelChangePinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChangePinLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel4)
                .addGap(73, 73, 73)
                .addGroup(panelChangePinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(oldPinTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelChangePinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPinTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(37, 37, 37)
                .addGroup(panelChangePinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(newPinConfirmTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
        );

        panelSVContainer.add(panelChangePin, "card4");

        openChangePinButtion.setText("Đổi PIN");
        openChangePinButtion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openChangePinPanel(evt);
            }
        });

        javax.swing.GroupLayout panelSVFunctionLayout = new javax.swing.GroupLayout(panelSVFunction);
        panelSVFunction.setLayout(panelSVFunctionLayout);
        panelSVFunctionLayout.setHorizontalGroup(
            panelSVFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSVFunctionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSVFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openChangePinButtion, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSVContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelSVFunctionLayout.setVerticalGroup(
            panelSVFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSVFunctionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSVFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSVFunctionLayout.createSequentialGroup()
                        .addComponent(openChangePinButtion, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelSVContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE))
                .addContainerGap())
        );

        parentPanel.add(panelSVFunction, "card9");

        getContentPane().add(parentPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectCard(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectCard
        // TODO add your handling code here:
        connectCard();
    }//GEN-LAST:event_connectCard

    private void openCreatePinPanel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openCreatePinPanel
        pinTextField.setText(null);
        pinConfirmTextField.setText(null);
        adminCardLayout.show(panelAdminContainer, CREATE_PIN_NAME);
    }//GEN-LAST:event_openCreatePinPanel

    private void backToEntry(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToEntry
        cardLayout.show(parentPanel, MAIN_CARD_NAME);
        clearAllTextField();
    }//GEN-LAST:event_backToEntry

    private void createPin(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPin
        String pin = pinTextField.getText();
        String pinConfirm = pinConfirmTextField.getText();
        if (pin.length() != 4) {
            JOptionPane.showMessageDialog(parentPanel, "Mã PIN cần có độ dài là 4");
            return;
        }
        if (!pinConfirm.equals(pin)) {
            JOptionPane.showMessageDialog(parentPanel, "Mã PIN không giống, kiểm tra lại");
            return;
        }
        if (!pin.matches("\\d+")) {
            JOptionPane.showMessageDialog(parentPanel, "Mã PIN chỉ chứa số 0-9");
            return;
        }
        smartCardWord.createPin(pin);
    }//GEN-LAST:event_createPin

    private void confirmChangePin(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmChangePin
        // TODO add your handling code here:
        String pin = oldPinTextField.getText();
        if (smartCardWord.checkPin(pin)) {
            String newPin = newPinTextField.getText();
            String confirmNewPin = newPinConfirmTextField.getText();
            if (newPin.length() != 4) {
                JOptionPane.showMessageDialog(parentPanel, "Mã PIN cần có độ dài là 4");
                return;
            }
            if (!confirmNewPin.equals(newPin)) {
                JOptionPane.showMessageDialog(parentPanel, "Mã PIN không giống, kiểm tra lại");
                return;
            }
            if (!newPin.matches("\\d+")) {
                JOptionPane.showMessageDialog(parentPanel, "Mã PIN chỉ chứa số 0-9");
                return;
            }
            smartCardWord.changePin(newPin);
        }
    }//GEN-LAST:event_confirmChangePin

    private void openChangePinPanel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openChangePinPanel
        // TODO add your handling code here:
        oldPinTextField.setText(null);
        newPinTextField.setText(null);
        newPinConfirmTextField.setText(null);
        cardLayout.show(panelSVContainer, CHANGE_PIN_CARD_NAME);
    }//GEN-LAST:event_openChangePinPanel

    private void adminFunction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminFunction
        // TODO add your handling code here:
        unlockCardTextField.setText(null);
        cardLayout.show(parentPanel, "card5");
    }//GEN-LAST:event_adminFunction

    private void openUnlockTab(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openUnlockTab
        // TODO add your handling code here:
        unlockCardTextField.setText(null);
        adminCardLayout.show(panelAdminContainer, "card2");
    }//GEN-LAST:event_openUnlockTab

    private void unlockCard(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unlockCard
        // TODO add your handling code here:
        String pin = unlockCardTextField.getText();
        smartCardWord.unlockCard(pin);
    }//GEN-LAST:event_unlockCard

    private void openGuiXeFunction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openGuiXeFunction
        // TODO add your handling code here:
        cardLayout.show(parentPanel, GUI_XE_FUNCTION_CARD_NAME);
    }//GEN-LAST:event_openGuiXeFunction

    private void openThuVienFunction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openThuVienFunction
        // TODO add your handling code here:
        cardLayout.show(parentPanel, THU_VIEN_CARD_NAME);
    }//GEN-LAST:event_openThuVienFunction

    private void openSVFunction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openSVFunction
        // TODO add your handling code here:
        cardLayout.show(parentPanel, SV_CARD_NAME);
    }//GEN-LAST:event_openSVFunction

    private void openEditFunction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openEditFunction
        // TODO add your handling code here:
        adminCardLayout.show(panelAdminContainer, EDIT_INFO_NAME);
    }//GEN-LAST:event_openEditFunction

    private void buttonResetInfounlockCard(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetInfounlockCard
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonResetInfounlockCard

    private void openLichSuGuiXeTab(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openLichSuGuiXeTab
        // TODO add your handling code here:
        guiXeCardLayout.show(panelGuiXeContainer, LICH_SU_GUI_XE_CARD_NAME);
    }//GEN-LAST:event_openLichSuGuiXeTab

    private void openGuiXeTab(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openGuiXeTab
        // TODO add your handling code here:
        guiXeCardLayout.show(panelGuiXeContainer, GUI_XE_CARD_NAME);
    }//GEN-LAST:event_openGuiXeTab

    private void openSachThuVienTab(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openSachThuVienTab
        // TODO add your handling code here:
        thuVienCardLayout.show(panelThuVienContainer, SACH_THU_VIEN_CARD_NAME);
    }//GEN-LAST:event_openSachThuVienTab

    private void openLichSuSachTab(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openLichSuSachTab
        // TODO add your handling code here:
        thuVienCardLayout.show(panelThuVienContainer, LICH_SU_SACH_CARD_NAME);
    }//GEN-LAST:event_openLichSuSachTab

    private void openMuonSachTab(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMuonSachTab
        // TODO add your handling code here:
        thuVienCardLayout.show(panelThuVienContainer, MUON_SACH_CARD_NAME);
    }//GEN-LAST:event_openMuonSachTab

    private void openTraSachTab(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openTraSachTab
        // TODO add your handling code here:
        thuVienCardLayout.show(panelThuVienContainer, TRA_SACH_CARD_NAME);
    }//GEN-LAST:event_openTraSachTab

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_Updateinfo;
    private javax.swing.JButton backButton2;
    private javax.swing.JButton backButton3;
    private javax.swing.JButton backButton4;
    private javax.swing.JButton backButton5;
    private javax.swing.JButton buttionAdminFunction;
    private javax.swing.JButton buttonCheckXe;
    private javax.swing.JButton buttonChooseAvatar;
    private javax.swing.JButton buttonCleanInfo;
    private javax.swing.JButton buttonConnect;
    private javax.swing.JButton buttonDoMuonSach;
    private javax.swing.JButton buttonDoTraSach;
    private javax.swing.JButton buttonEditÌno;
    private javax.swing.JButton buttonFlushInfoCard;
    private javax.swing.JButton buttonGuiXeFunction;
    private javax.swing.JButton buttonGuiXeTab;
    private javax.swing.JButton buttonLichSuGuiXe;
    private javax.swing.JButton buttonLichSuSach;
    private javax.swing.JButton buttonListSach;
    private javax.swing.JButton buttonMuonSach;
    private javax.swing.JButton buttonResetInfo;
    private javax.swing.JButton buttonSVFunction;
    private javax.swing.JButton buttonThuVienFunction;
    private javax.swing.JButton buttonTimKiemLS;
    private javax.swing.JButton buttonTimKiemMS;
    private javax.swing.JButton buttonTimKiemS;
    private javax.swing.JButton buttonTraSach;
    private javax.swing.JButton buttonUnlockCard;
    private javax.swing.JTextField cb_LopSV;
    private javax.swing.JComboBox cb_NamSinhSV;
    private javax.swing.JComboBox cb_NgaySinhSV;
    private javax.swing.JComboBox cb_ThangSinhSV;
    private javax.swing.JButton confirmButton;
    private javax.swing.JButton createPinButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel labelAvatarSV;
    private javax.swing.JLabel labelBienSoXe;
    private javax.swing.JLabel labelCardStatus;
    private javax.swing.JLabel labelHangXe;
    private javax.swing.JLabel labelHoTenTraSach;
    private javax.swing.JLabel labelMSVTraSach;
    private javax.swing.JLabel labelMauSacXe;
    private javax.swing.JLabel labelTrangThaiXe;
    private javax.swing.JPasswordField newPinConfirmTextField;
    private javax.swing.JPasswordField newPinTextField;
    private javax.swing.JPasswordField oldPinTextField;
    private javax.swing.JButton openChangePinButtion;
    private javax.swing.JPanel panelAdminContainer;
    private javax.swing.JPanel panelAdminFunction;
    private javax.swing.JPanel panelCardStatus;
    private javax.swing.JPanel panelChangePin;
    private javax.swing.JPanel panelCleanInfo;
    private javax.swing.JPanel panelEditInfo;
    private javax.swing.JPanel panelFlushInfo;
    private javax.swing.JPanel panelGuiXe;
    private javax.swing.JPanel panelGuiXeContainer;
    private javax.swing.JPanel panelGuiXeFunction;
    private javax.swing.JPanel panelLichSuGuiXe;
    private javax.swing.JPanel panelLichSuSach;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelMuonSach;
    private javax.swing.JPanel panelSVContainer;
    private javax.swing.JPanel panelSVFunction;
    private javax.swing.JPanel panelSachThuVien;
    private javax.swing.JPanel panelThuVienContainer;
    private javax.swing.JPanel panelThuVienFunction;
    private javax.swing.JPanel panelTraSach;
    private javax.swing.JPanel panelUnlockCard;
    private javax.swing.JPanel parentPanel;
    private javax.swing.JPasswordField pinConfirmTextField;
    private javax.swing.JPasswordField pinTextField;
    private javax.swing.JRadioButton rButtonGenderFemale;
    private javax.swing.JRadioButton rButtonGenderMale;
    private javax.swing.JTable tableLichSuGuiXe;
    private javax.swing.JTable tableLichSuSach;
    private javax.swing.JTable tableMuonSach;
    private javax.swing.JTable tableSach;
    private javax.swing.JTable tableSachDangMuon;
    private javax.swing.JTable tableSinhVien;
    private javax.swing.JTextField textFieldPinCleanInfo;
    private javax.swing.JTextField textFieldTimKiemLS;
    private javax.swing.JTextField textFieldTimKiemMS;
    private javax.swing.JTextField textFieldTimKiemS;
    private javax.swing.JTextField textFileldEditNameSV;
    private javax.swing.JTextField tf_Masinhvien;
    private javax.swing.JTextField tf_SoDienThoaiSV;
    private javax.swing.JButton unlockButton;
    private javax.swing.JTextField unlockCardTextField;
    // End of variables declaration//GEN-END:variables

    private void connectCard() {
        if (smartCardWord.isConnected()) {
            buttonConnect.setText("Connect");
            labelCardStatus.setText("Card disconnected");
            panelCardStatus.setBackground(Color.RED);
            
            smartCardWord.disconnect();
            JOptionPane.showMessageDialog(rootPane, "Ngắt kết nối thành công");
            enableFunction(false);
        } else {
            boolean check = smartCardWord.connectAndSelectDefaultApplet();
            if (check) {
                buttonConnect.setText("Disconnect");
                labelCardStatus.setText("Card connected");
                panelCardStatus.setBackground(Color.GREEN);
            
                JOptionPane.showMessageDialog(rootPane, "Kết nối thành công");
                enableFunction(true);
            }
        }
    }
    
    private void enableFunction(boolean enable) {
        buttonFlushInfoCard.setEnabled(enable);
        openChangePinButtion.setEnabled(enable);
    }

    private void setBackgroundColor() {
        panelAdminFunction.setBackground(Color.PINK);
        panelCardStatus.setBackground(Color.RED);
        panelMain.setBackground(Color.PINK);
        panelGuiXeFunction.setBackground(Color.PINK);
        panelThuVienFunction.setBackground(Color.PINK);
        panelSVFunction.setBackground(Color.PINK);
        // admin
        panelUnlockCard.setBackground(Color.WHITE);
        panelFlushInfo.setBackground(Color.WHITE);
        panelEditInfo.setBackground(Color.WHITE);
        // SV
        panelChangePin.setBackground(Color.WHITE);
        // Gui xe
        panelGuiXe.setBackground(Color.WHITE);
        panelLichSuGuiXe.setBackground(Color.WHITE);
        // Thu vien
        panelSachThuVien.setBackground(Color.WHITE);
        panelLichSuSach.setBackground(Color.WHITE);
        panelMuonSach.setBackground(Color.WHITE);
        panelTraSach.setBackground(Color.WHITE);
    }
    
    private void clearAllTextField() {
        unlockCardTextField.setText(null);
        pinConfirmTextField.setText(null);
        pinTextField.setText(null);
        oldPinTextField.setText(null);
        newPinConfirmTextField.setText(null);
        newPinTextField.setText(null);
    }
}
