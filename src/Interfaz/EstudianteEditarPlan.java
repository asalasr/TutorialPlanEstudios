package Interfaz;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Console.Logic_Console;
import Planner.Curso;
import Planner.Estudiantes;
import Planner.Plan;



public class EstudianteEditarPlan extends JPanel{

	JPanel panel;
	InterfazPrincipal main;
	private Logic_Console Logica;
	private JTextField Nombre;
	private JTextField CodigoCurso;
	private JButton Buscar; 
	private int Creditos;
	private ArrayList<Curso> CInscritos;
	private JTextArea cursos;
	private JLabel dCreditos;
	ArrayList<Curso> Correquisitos = new ArrayList<Curso>();
	ArrayList<Curso> Aeliminar = new ArrayList<Curso>();
	ImageIcon iconHome = new ImageIcon("data/Botones/btnHomeB.png");
	ImageIcon iconBack = new ImageIcon("data/Botones/btnBack.png");

	public EstudianteEditarPlan(JPanel p, InterfazPrincipal pInterfazPrincipal, Plan pPlan) {
		
		Logica = pInterfazPrincipal.darLogic_Console();
		main = pInterfazPrincipal;
		panel= p;
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		

		gbc.insets=new Insets(5,5,5,5);

		
		JLabel bienvenido = new JLabel();
		bienvenido.setText("Editar Plan");
		bienvenido.setFont(new Font("Aharoni", Font.PLAIN, 40));
		bienvenido.setSize(800, 000);
		gbc.gridx=0;
		gbc.gridy=0;
		
		add(bienvenido,gbc);
	
		
		JButton siguiente = new JButton();
		siguiente.setOpaque(false);
		siguiente.setContentAreaFilled(false);
		siguiente.setBorderPainted(false);
		siguiente.setSize(800, 200);
		
		siguiente.setIcon(iconHome);

		siguiente.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	abrirMenuPrincipal(e);	
	            }
		});
		gbc.gridx=1;
		gbc.gridy=3;
		add(siguiente,gbc);
		
		JButton back = new JButton();
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setIcon(iconBack);
		back.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				back();
			}
			
		});
		gbc.gridx=2;
		gbc.gridy=3;
		add(back, gbc);
		

		JPanel DisplayCursosInscritos = new JPanel() ;
		DisplayCursosInscritos.setLayout(new BoxLayout(DisplayCursosInscritos, BoxLayout.Y_AXIS));
		DisplayCursosInscritos.updateUI();
		ShowCursos(DisplayCursosInscritos, pPlan);
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(DisplayCursosInscritos, gbc);
		
		JPanel Botones = new JPanel();
		Botones.setLayout(new BoxLayout(Botones, BoxLayout.Y_AXIS));
		
		JPanel Busqueda = new JPanel();
		Busqueda.setLayout(new BoxLayout(Busqueda, BoxLayout.Y_AXIS));
		

		
		Nombre = new JTextField(); 
		Nombre.setText("Nombre");
		Nombre.setForeground(new Color(162,162,162));
		Nombre.addMouseListener(new MouseListener() {
			int click = 0;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(click==0) {
				Nombre.setText("");
				Nombre.setForeground(Color.BLACK);
				System.out.println("CLICk");
				click++;
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		Busqueda.add(Nombre);
		
		CodigoCurso = new JTextField(); 
		CodigoCurso.setText("CodigoCurso");
		CodigoCurso.setForeground(new Color(162,162,162));
		CodigoCurso.addMouseListener(new MouseListener() {
			int click = 0;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(click==0) {
					CodigoCurso.setText("");
					CodigoCurso.setForeground(Color.BLACK);
				System.out.println("CLICk");
				click++;
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		Busqueda.add(CodigoCurso);
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(Busqueda,gbc);
	
		
		Buscar = new JButton();
		Buscar.setText("Buscar");
		
		Buscar.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				String n = Nombre.getText();
				String c = CodigoCurso.getText();
				if(n.equals("Nombre") && c.equals("CodigoCurso")) {
					n="";
					c="";
				}else if(c.equals("CodigoCurso")) {
					c= "";
				}else if(n.equals("Nombre")) {
					n="";
				}
				funcionMain(n,c,pPlan);
				}
			
		});
		
		JButton Eliminar = new JButton();
		Eliminar.setText("Eliminar");
		
		Eliminar.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				String n = Nombre.getText();
				String c = CodigoCurso.getText();
				if(n.equals("Nombre") && c.equals("CodigoCurso")) {
					n="";
					c="";
				}else if(c.equals("CodigoCurso")&& !n.equals("Nombre")) {
					c= "";
					n=n+"#";
				}else if(n.equals("Nombre")&& !n.equals("CodigoCurso")) {
					n="";
					c=c+"#";
				}else if(c.equals("CodigoCurso")) {
					c= "";
				}else if(n.equals("Nombre")) {
					n="";
				}
				
		
				funcionMain(n,c,pPlan);
				}
			
		});
		
		JButton MostrarCursos = new JButton();
		MostrarCursos.setText("MOSTAR CURSOS");
		MostrarCursos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				main.cards.add(new EstudianteMostrarCursos(main.cards, main), "EstMostrarCursos");
				main.switchPanel(panel, "EstMostrarCursos");
				
			}
			
		});
		
		
		
		JButton Guardar = new JButton();
		Guardar.setText("Guardar");
		Guardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Estudiantes e1 = Logica.darEstudiante();
				CInscritos = pPlan.darCursos();
				Logica.VerificadorCorrequisitos( CInscritos, Correquisitos, Aeliminar);
				Logica.inscribirAPlan(e1.darCodigo(), CInscritos, e1.darPlanes().size(), pPlan.darNombre());
				main.switchPanel(panel, "estPlan");
			}
			
		});
		Botones.add(Buscar);
		Botones.add(Eliminar);
		Botones.add(MostrarCursos);
		Botones.add(Guardar);
		gbc.gridx = 2;
		gbc.gridy = 1;
		
		add(Botones,gbc);
		
	
	}
	
	//--------------------------------
	//transition methods
	//------------------------------
	
	public void ShowCursos(JPanel displayCursosInscritos, Plan pPlan) {
		displayCursosInscritos.updateUI();
		if (pPlan==null) {
			JTextArea cursos = new JTextArea();
			String info="Cursos Planeados: "
					+ "\n  Nombre   -   Codigo  -  Creditos";

		}else {
			int resta =0; 
			Iterator<Curso> iCurso2 = pPlan.darCursos().iterator();
			String info="Cursos Planeados: "
					+ "\n  Nombre   -   Codigo  -  Creditos";
			while(iCurso2.hasNext()) {
				Curso cA2 = iCurso2.next();
				info = info +" \n → "+ cA2.darNombre()+" - "+cA2.darCodigo() + " - " + String.valueOf(cA2.darCreditos()) ;
				resta= resta + cA2.darCreditos();
			}
			displayCursosInscritos.removeAll();
			cursos = new JTextArea();
			cursos.setEditable(false);
			cursos.setText(info);
			cursos.setFont(new Font("Century Gothic", Font.PLAIN, 12));

			JScrollPane scrollCursos= new JScrollPane(cursos);
			scrollCursos.setPreferredSize(new Dimension(300,300));
			scrollCursos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			displayCursosInscritos.add(scrollCursos);
			scrollCursos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), pPlan.darNombre(), TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
			DarNumCreditos(resta); 
			dCreditos = new JLabel();
			dCreditos.setText("Creditos: "+ (String.valueOf(Creditos)));
			displayCursosInscritos.add(dCreditos);
	}}

	
	
	public void DarNumCreditos(int resta) {
		if (Logica.darEstudiante().darPromedioAcumulado()>=4.0) {
			Creditos = 25-resta;
			

			
		}else {
			Creditos = 20-resta;
		}
	}
	
	
	
	public void funcionMain(String n, String c, Plan pPlan) {
		
		Estudiantes e1 = Logica.darEstudiante();
		int alertcambio;
		ArrayList<Curso> CInscritos;

		if (pPlan!= null) {
			CInscritos = pPlan.darCursos() ;
			 alertcambio = CInscritos.size(); 
			}
		else {
			CInscritos = new ArrayList<Curso>();	
			 alertcambio =0;
		}

		if((n.equals("") && c.equals(""))) {
			JOptionPane.showMessageDialog(this, "Campos vacios");
			
		}else if(n.equals("") && !c.equals("")) {
			try {
				ArrayList<Curso> lst= Logica.verificadorDerequisitos(c, Creditos, Logica.darEstudiante(), CInscritos, Correquisitos, Aeliminar);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, "Curso No encontrado ");

				e.printStackTrace();
			}
			e1.darPlanes().get(e1.darPlanes().indexOf(pPlan)).guardarplan(CInscritos);
			if (CInscritos.size()> alertcambio) {
				Curso CursoA = CInscritos.get(CInscritos.size()-1);
				cursos.setText(cursos.getText()+"\n"+CursoA.darNombre() +"; "+ CursoA.darCodigo());
				Creditos = Creditos - CursoA.darCreditos();
				dCreditos.setText(String.valueOf(Creditos));
				dCreditos.updateUI();
				alertcambio++;
			}			
		}else if(!n.equals("") && c.equals("")) {

			try {
				ArrayList<Curso> lst = Logica.verificadorDerequisitos(n, Creditos, Logica.darEstudiante(), CInscritos, Correquisitos, Aeliminar);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, "Curso No encontrado ");

				e.printStackTrace();
				
			}
			e1.darPlanes().get(e1.darPlanes().indexOf(pPlan)).guardarplan(CInscritos);
			if (CInscritos.size()> alertcambio) {
				Curso CursoA = CInscritos.get(CInscritos.size()-1);
				cursos.setText(cursos.getText()+"\n"+CursoA.darNombre() +"; "+ CursoA.darCodigo());
				Creditos = Creditos - CursoA.darCreditos();
				dCreditos.setText(String.valueOf(Creditos));
				dCreditos.updateUI();
				alertcambio++;
				}
	
		} else {
			try {
				ArrayList<Curso> lst =Logica.verificadorDerequisitos(n, Creditos, Logica.darEstudiante(), CInscritos, Correquisitos, Aeliminar);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Curso No encontrado ");
				e.printStackTrace();
			}
			e1.darPlanes().get(e1.darPlanes().indexOf(pPlan)).guardarplan(CInscritos);
			if (CInscritos.size()> alertcambio) {
				Curso CursoA = CInscritos.get(CInscritos.size()-1);
				cursos.setText(cursos.getText()+"\n"+CursoA.darNombre() +"; "+ CursoA.darCodigo());
				Creditos = Creditos - CursoA.darCreditos();
				dCreditos.setText(String.valueOf(Creditos));
				dCreditos.updateUI();
				alertcambio++;
				}
			

		}
		
	}
	

	public void abrirMenuPrincipal(ActionEvent e) {
		
		main.switchPanel(panel, "estMenu");
		
	}	
	private void back() {
		main.switchPanel(panel, "estPlan");
	}

	
	
	
}
