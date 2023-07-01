package componentMainCustomer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import animation.TextField;
import animation.TextPane;
import componentScrollPane.ScrollBarMainCustomer;
import interfaces.ChatEvent;
import model.ModelMessenger;
import net.miginfocom.swing.MigLayout;

public class PanelChat extends JPanel {

	private MigLayout layout;
	private JPanel header;
	private JPanel body;
	private JPanel footter;

	private JScrollPane scrollBody;
	private JLayeredPane layeredPane;
	private MigLayout layoutLayered;

	private List<ChatEvent> events = new ArrayList<>();
	private TextPane txtMessenger;
	private Button floatingButton;
	private AnimationScroll animationScroll;
	private AnimationFloatingButton animationFloatingButton;

	public PanelChat() {
		setOpaque(false);
		layout = new MigLayout("fill, wrap, inset 0", "[fill]", "[fill,0!][fill,100%][shrink 0,::30%]");

		header = createHeader();

		body = createBody();

		footter = createFootter();

		layeredPane = createLayeredPane();

		scrollBody = createScroll();
		scrollBody.setViewportView(body);
		scrollBody.setVerticalScrollBar(new ScrollBarMainCustomer());
		scrollBody.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollBody.getViewport().setOpaque(false);
		
		scrollBody.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
			private int oldValues;

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				int value = scrollBody.getVerticalScrollBar().getValue();
				int extent = scrollBody.getVerticalScrollBar().getModel().getExtent();

				if ((value + extent) >= scrollBody.getVerticalScrollBar().getMaximum() - 300) {
					animationFloatingButton.hide();

				} else if (oldValues <= e.getValue()) {
					if (!animationScroll.isRunning()) {
						animationFloatingButton.show();
					}
				}
			}
		});
		floatingButton = createFloatingButton();

		layeredPane.setLayer(floatingButton, JLayeredPane.POPUP_LAYER);
		layeredPane.add(floatingButton, "pos 100%-50 100%,h 40,w 40");
		layeredPane.add(scrollBody);

		setLayout(layout);
		add(header);
		add(layeredPane);
		add(footter);
		initAnimator();
	}

	private void initAnimator() {
		animationScroll = new AnimationScroll(body);
		animationFloatingButton = new AnimationFloatingButton(layoutLayered, floatingButton);
	}

	public void addEvent(ChatEvent event) {
		events.add(event);
	}

	public void addChatBox(ModelMessenger messenger, ChatBox.BoxType type) {
		int values = scrollBody.getVerticalScrollBar().getValue();
	
		if (type == ChatBox.BoxType.LEFT) {
			body.add(new ChatBox(type, messenger), "width :: 80%");
		} else {
			body.add(new ChatBox(type, messenger), "al right,width ::80%");
		}

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				body.revalidate();
				scrollBody.getVerticalScrollBar().setValue(values);
				footter.revalidate();
			}
		});
		
		body.repaint();
		body.revalidate();
		scrollBody.revalidate();
		scrollToFootter();
	}

	private void scrollToFootter() {
		animationScroll.scrollVertical(scrollBody, scrollBody.getVerticalScrollBar().getMaximum());
		
	}

	public Button createFloatingButton() {
		Button button = new Button();
		button.setBorder(null);
		button.setIcon(new ImageIcon(PanelChat.class.getResource("/icon/down-arrow.png")));
		button.setRound(40);
		button.setBackground(new Color(242,242,242));
		button.setPaintBackground(true);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				animationScroll.scrollVertical(scrollBody, scrollBody.getVerticalScrollBar().getMaximum());

			}
		});
		return button;
	}

	public JPanel createHeader() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		return panel;
	}

	public JPanel createBody() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(new MigLayout("wrap,fillx"));
		return panel;
	}

	private JScrollPane createScroll() {
		JScrollPane scroll = new JScrollPane();
		scroll.setBorder(null);
		scroll.setViewportBorder(null);
		return scroll;
	}

	public JPanel createFootter() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(242,242,242));
		panel.setLayout(new MigLayout("fill, inset 0", "[fill, 34!]2[fill]2[fill, 34!]", "[bottom]"));

		Button cmdFile = new Button();
		cmdFile.setIcon(new ImageIcon(PanelChat.class.getResource("/icon/plus-custom.png")));

		txtMessenger = new TextPane();
		txtMessenger.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtMessenger.setForeground(Color.decode("#93291E"));
		txtMessenger.setBackground(new Color(255,255,255));
		txtMessenger.setHint("Aa...");

		txtMessenger.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				revalidate();
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

		});

		JScrollPane scroll = createScroll();
		scroll.setViewportView(txtMessenger);
		scroll.getViewport().setOpaque(false);
		scroll.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		scroll.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));

		Button cmdSend = new Button();
		cmdSend.setIcon(new ImageIcon(PanelChat.class.getResource("/icon/send-custom.png")));

		cmdSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				runEventMousePressedSendButton(e);

			}
		});

		panel.add(cmdFile, "height 34!");
		panel.add(scroll);
		panel.add(cmdSend, "height 34!");

		return panel;
	}

	private JLayeredPane createLayeredPane() {
		JLayeredPane layer = new JLayeredPane();
		layoutLayered = new MigLayout("fill,inset 0", "[fill]", "[fill]");
		layer.setLayout(layoutLayered);
		return layer;
	}

	public void runEventMousePressedSendButton(ActionEvent event) {
		for (ChatEvent chatEvent : events) {
			chatEvent.mousePressedSendButton(event);
		}
	}
	
	public void clearTextAndGrabFocus() {
		txtMessenger.setText("");
		txtMessenger.grabFocus();
	}

	public TextPane getTxtMessenger() {
		return txtMessenger;
	}

	public void setTxtMessenger(TextPane txtMessenger) {
		this.txtMessenger = txtMessenger;
	}

	
	
	
}
