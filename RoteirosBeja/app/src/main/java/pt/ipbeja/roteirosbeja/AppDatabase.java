package pt.ipbeja.roteirosbeja;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

    @Database(
        version = 2,
        entities = {Monument.class, InterestPoint.class}
    )

public abstract class AppDatabase extends RoomDatabase{

    public abstract MonumentDao getMonumentDAO();

    public abstract InterestPointDao getInterestingPointDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "roteirosDB")
                    .allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                    //        db.execSQL("CREATE TABLE Monument (id, title, shortDescription, longDescription, image)");
                    //        db.execSQL("CREATE TABLE InterestPoint (id, name, images)");

                            db.execSQL("INSERT INTO Monument (id, title, shortDescription, longDescription, image) VALUES ('1', 'Castelo de Beja', 'O Castelo de Beja ergue-se sobre a cidade, concelho e distrito de Beja, em Portugal.', 'Fortificação medieval que é o monumento mais emblemático da cidade. A sua Torre de Menagem, com quase 40 metros de altura, é considerada por alguns autores como a torre militar mais alta do país.', 'https://cdn.olhares.com/client/files/foto/big/897/8975177.jpg')");
                            db.execSQL("INSERT INTO Monument (id, title, shortDescription, longDescription, image) VALUES ('2', 'Museu Rainha D. Leonor', 'Também referido como Museu Regional de Beja, no Alentejo, localiza-se nas dependências do antigo Convento da Conceição, na freguesia de Santa Maria da Feira, na cidade e concelho de Beja', 'O edifício do convento encontra-se classificado como Monumento Nacional desde 1922.\n" +
                                    "\n" +
                                    "O Convento foi fundado em 1459 pelo Infante D. Fernando, irmão de Afonso V de Portugal, e sua esposa, a Infanta D. Beatriz. O convento, primitivamente era bastante amplo mas, séculos mais tarde, sofreu a demolição de uma parte.\n" +
                                    "\n" +
                                    "Este museu conheceu três fases distintas enquanto instituição museológica:\n" +
                                    "\n" +
                                    "Museu Sisenando-Cenáculo-Pacense, entre os anos de 1791 e 1802\n" +
                                    "Museu Archeologico Municipal de Beja, entre os anos de 1892 e 1927\n" +
                                    "Museu Rainha Dona Leonor ou Museu Regional de Beja, de 1927 até à actualidade', 'https://www.radiopax.com/wp-content/uploads/2020/05/museu.jpg')");
                            db.execSQL("INSERT INTO Monument (id, title, shortDescription, longDescription, image) VALUES ('3', 'Villa Romana de Pisões', 'Sítio arqueológico no concelho de Beja, em Portugal. Consiste numa grande casa senhorial do período romano, que foi ocupada desde o Século I até ao domínio visigótico.', 'A estação arqueológica está situada na Herdade da Almocreva, a cerca de 10 Km da cidade de Beja, numa zona conhecida como barros de Beja. O complexo arqueológico ocupa cerca de seis hectares, enquanto que a villa romana em si tem mais de 5000 m².', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/Roman_Villa_of_Pis%C3%B5es%2C_Portugal_%2816614021360%29.jpg/1280px-Roman_Villa_of_Pis%C3%B5es%2C_Portugal_%2816614021360%29.jpg')");




                            db.execSQL("INSERT INTO InterestPoint (idPoint, eachInterestID, name, description, images, maps) VALUES ('1', '1', 'Castelo de Beja', 'Os vestígios do castelo situam-se no topo de uma colina, ao longo da qual se estendem as fortificações muralhadas da cidade de Beja, rodeadas por jardins paisagísticos. Imediatamente nas proximidades encontram-se a Sé Catedral, a Capela de Santo Amaro, o edifício do Hospital da Misericórdia, as residências das famílias Guedes e Campos e o Paço Municipal.\n" +
                                    "\n" +
                                    "O castelo é o núcleo principal de um conjunto de fortificações que engloba a cidade medieval, implantado no seu canto noroeste. É uma planta pentagonal irregular, com uma barbacã irregular parcialmente circundada ao norte e ao sul. As duas linhas de paredes são revestidas por merlões paralelos sobre canhoneiras, circundados internamente por adarves e reforçados por cachorros e torres.', 'https://cdn.olhares.com/client/files/foto/big/897/8975177.jpg', 'https://i.gyazo.com/98d2f86aba39f97c554e654cf60b6e3d.png')");


                            db.execSQL("INSERT INTO InterestPoint (idPoint, eachInterestID, name, description, images, maps) VALUES ('2', '1', 'Torre de Menagem', 'Embora a primitiva ocupação humana do seu sítio remonte à pré-história e esteja mencionada nos escritos de Ptolomeu e de Políbio, em meados do século II a.C., a sua fortificação data da Invasão romana da Península Ibérica, plausivelmente, devido à importância adquirida no cenário regional. Foi este o local escolhido por Júlio César para formalizar a paz com os Lusitanos (49d.C), após o que passou a se denominar de Pax Julia, vindo a sediar uma das três jurisdições romanas da Lusitânia. Acredita-se que os muros de defesa romanos remontem algures entre o século III e o século IV.\n" +
                                    "\n" +
                                    "Essa relevância económica e estratégica de Beja manteve-se à época dos Suevos, dos Visigodos, bem como sob a ocupação Muçulmana.','https://www.tribunaalentejo.pt/sites/default/files/styles/article_teaser/public/field/image/beja_torre_0.png?itok=sHMjZwCG', 'https://i.gyazo.com/11fb25ad46deb18a63798208501b8a6c.png')");

                            db.execSQL("INSERT INTO InterestPoint (idPoint, eachInterestID, name, description, images, maps) VALUES ('5', '1', 'Portas de Avis', 'As Portas de Avis, são um arco romano de pedra granítica, situado junto ao Terreirinho das Peças. Foi em tempos encimado por uma Ermida (Nossa Senhora da Guia), tendo sido ambos demolidos em finais do século XIX. No século XX, mais precisamente em 1939, o arco foi reconstruído, ficando com a estrutura atual.\n" +
                                    "\n" +
                                    "Até ao século XX, alguns autores, identificavam a Pax Julia romana com a cidade espanhola de Badajoz. Esta identificação foi avançada por Rodrigo Dosma, um cónego de Badajoz do século XVI, em cuja época era habitual a elaboração mais ou menos fantasiosa, quando não completamente inventada, da história de cidades, com o objetivo de demonstrar uma grande antiguidade e a origem romana ou anterior.', 'https://media-cdn.tripadvisor.com/media/photo-s/12/98/af/d1/arco-das-portas-de-avis.jpg', 'https://i.gyazo.com/98f5bd07b511aa6f6b6247bbb9301064.png')");

                            db.execSQL("INSERT INTO InterestPoint (idPoint, eachInterestID, name, description, images, maps) VALUES ('4', '1', 'Sé Catedral de Beja', 'A paróquia de Santiago Maior é uma das mais antigas de Beja. No início, teve sede na Igreja de Santo Amaro, mas no século XIV foi transferida para este local, onde já existia uma igreja.\n" +
                                    "\n" +
                                    "O templo atual, em estilo maneirista, data de 1590, quando foi construído por vontade do arcebispo D. Teotónio de Bragança segundo um projeto de Jorge Rodrigues. Em matéria de arquitetura, este templo segue a tipologia maneirista, já aplicada noutros monumentos do Alentejo, como, por exemplo, na Igreja de Santo António em Évora.\n" +
                                    "\n" +
                                    "No interior, ricamente decorado, destacam-se o retábulo da capela-mor em talha dourada da autoria do mestre lisboeta Manuel João da Fonseca, datado de 1696-97.\n" +
                                    "\n" +
                                    "Na década de 1930, o bispo de Beja D. José Patrocínio Dias solicitou à Santa Sé a elevação da Igreja de Santiago Maior a Sé Catedral de Beja, consagrada ao Sagrado Coração de Jesus, sendo a única em Portugal que não segue a invocação de Nossa Senhora da Conceição. Foram então efetuadas obras de restauro, nas quais se valorizaram as componentes maneiristas e barrocas, e enriqueceu-se o tesouro da Sé com peças de arte sacra provenientes de conventos extintos de Lisboa e do património da Casa de Bragança.','https://dynamic-media-cdn.tripadvisor.com/media/photo-o/15/84/10/63/cattedrale-di-beja-facciata.jpg?w=1200&h=-1&s=1', 'https://i.gyazo.com/8469ce10b8e34a8ac68533a171b68735.png')");

                            db.execSQL("INSERT INTO InterestPoint (idPoint, eachInterestID, name, description, images, maps) VALUES ('3', '1', 'Museu Jorge Vieira', 'Instalado, desde maio de 1995, num edifício do centro histórico da cidade, encontra-se desde 1 de setembro de 2019 na antiga casa do Governador, no Castelo de Beja, albergando um importante conjunto de esculturas, maquetas e desenhos da autoria de Jorge Vieira, artista plástico que marcou o percurso da arte portuguesa ao longo do século XX. Jorge Ricardo da Conceição Vieira nasceu em Lisboa, a16 de novembro de1922. Entre 1944 e 1953 frequentou a Escola de Belas-Artes de Lisboa, onde começou por se matricular em arquitetura transitando depois para escultura. Foi aluno de Simões de Almeida e Leopoldo de Almeida e trabalhou nos ateliers de António Duarte, Francisco Franco e António Rocha.','https://visitasdeestudo.pt/wp-content/uploads/2020/03/Museu-Jorge-Vieira-00.jpg', 'https://i.gyazo.com/c463c2f829d2435f698286b0d3257a5e.png')");





                            db.execSQL("INSERT INTO InterestPoint (idPoint, eachInterestID, name, description, images, maps) VALUES ('6', '2', 'Museu Rainha D. Leonor', 'A colecção principal compreende a secção de arqueologia romana, com peças encontradas na região reveladoras da ocupação do território durante o império de Júlio César, a secção de epigrafia e heráldica medieval, constituída por um conjunto de brasões e lápides tumulares, e, no 2º piso do museu, a apresentação do espólio reunido pelo arqueólogo Fernando Nunes Ribeiro e doado à cidade, com peças desde a Idade do Bronze até à actualidade. O Convento foi fundado em 1459 pelo Infante D. Fernando, irmão de Afonso V de Portugal, e sua esposa, a Infanta D. Beatriz. O convento, primitivamente era bastante amplo mas, séculos mais tarde, sofreu a demolição de uma parte.', 'https://www.info4camper.com/fotos/visitar/pt/large/photos-7488-8836-museu_rainha_dona_leonor.jpg?image=2', 'https://i.gyazo.com/269d046f447b1ffeb38fd2e5be47f9d6.png')");

                            db.execSQL("INSERT INTO InterestPoint (idPoint, eachInterestID, name, description, images, maps) VALUES ('7', '2', 'Estátua da Rainha Dona Leonor', 'Leonor de Avis ou Leonor de Portugal (1458-1525) foi Rainha ao lado do Rei D. João II (1455-1495).\n" +
                                    "Esta estátua está numa rotunda, com bastante intensidade de tráfego rodoviário em redor, voltada de frente para o Parque D. Carlos I, e foi inaugurada em 1935.\n" +
                                    "É uma obra do escultor Francisco Franco (1885-1955), homenagendo a monarca que mandou erguer nas Caldas da Rainha, um hospital termal, inaugurado em 1488, dinamizando assim este pequeno lugar com cerca de 30 habitantes, transformando-o na grande cidade que se ergueu em volta do complexo de \"águas quentes curativas e de cheiro forte\".', 'https://www.allaboutportugal.pt/imagethumb/1700x/resize/770766', 'https://i.gyazo.com/3cf32354d1d11d5e0edde5bae61eeaf1.png')");

                            db.execSQL("INSERT INTO InterestPoint (idPoint, eachInterestID, name, description, images, maps) VALUES ('8', '2', 'Cine-Teatro Pax Julia', 'O Teatro Pax Julia foi inaugurado em 28 de Dezembro de 1928.\n" +
                                    "\n" +
                                    "Em 1952, depois de uma grande remodelação, passou a chamar-se Cine-Teatro.\n" +
                                    "\n" +
                                    "Em 1990 fechou portas.\n" +
                                    "\n" +
                                    "Foi inaugurado como Teatro Municipal em 17 de Junho de 2005 num espectáculo com Sérgio Godinho, Rão Kyao, Vitorino, Janita Salomé e Filipa Pais. É constituido por um auditório com 620 lugares e uma sala-estúdio com 130 lugares, além da cafetaria.', 'https://semmais.pt/wp-content/uploads/2020/11/848014.jpg', 'https://i.gyazo.com/c5ed6314ce95239771e7c7e031310738.png')");

                            db.execSQL("INSERT INTO InterestPoint (idPoint, eachInterestID, name, description, images, maps) VALUES ('9', '2', 'Pelourinho de Beja', 'Este foi mandado construir pelo rei D. Manuel I, após concessão do foral de 1521. Teria sido inicialmente instalado no terreiro dos Paços do Concelho, sendo no início do século XIX transferido para a atual Praça da República. À semelhança de outros do mesmo período, teria no topo os emblemas do monarca, nomeadamente a esfera armilar e a cruz de Cristo. No decorrer do século XIX, em data desconhecida, terá sido desmontado, tendo desaparecido grande parte dos seus elementos, apenas se preservando o capitel, o remate e parte do fuste. Em 1938 foi reconstruído, mas com a introdução de algumas alterações, não sendo incluídos os elementos que se conservavam do século XVI, para, em 2001, ter sofrido um acidente que o danificou. É um fruto de uma perspetiva para com o património histórico muito comum na primeira metade do século XX.', 'https://live.staticflickr.com/68/185721718_6a569d5ce0_b.jpg', 'https://i.gyazo.com/b81dce66c67698df4bac2836b471b775.png')");

                            db.execSQL("INSERT INTO InterestPoint (idPoint, eachInterestID, name, description, images, maps) VALUES ('10', '2', 'Igreja da Misericórdia', 'Erguida no século XVI a mando do Infante D. Luís, trata-se de um edifício único no panorama da arquitectura portuguesa.\n" +
                                    "\n" +
                                    "Trata-se de um edifício único no panorama da arquitectura nacional. Quando, pouco depois de 1530, o infante D. Luís, duque de Beja, mandou erguer a actual Igreja da Misericórdia, a ideia era fazer uns açougues no topo da principal praça da cidade. O edifício seguia a tipologia das loggia italianas, profundamente influenciado pelo Renascimento italiano.\n" +
                                    "\n" +
                                    "O edifício tinha tal magnificência que o próprio D. Luís o considerou desadequado para a sua função inicial, tendo-o oferecido à confraria da Santa Casa da Misericórdia para a instalação da respectiva igreja, sendo adaptado a esta função.', 'https://cm-beja.pt/util/imgLoader2.ashx?img=/upload_files/client_id_1/website_id_1/Beja/IMG_597111.JPG', 'https://i.gyazo.com/e9cdd93daa6dde76dd8347232e0435fb.png')");


                            db.execSQL("INSERT INTO InterestPoint (idPoint, eachInterestID, name, description, images, maps) VALUES ('11', '3', 'Villa Romana de Pisões', 'A Villa romana de Pisões é um sítio arqueológico no concelho de Beja, em Portugal. Consiste numa grande casa senhorial do período romano, que foi ocupada desde o Século I até ao domínio visigótico. É uma das principais e melhor conservadas villas romanas em todo o país, tendo sido classificada como Imóvel de Interesse Público. É especialmente conhecida devido à riqueza dos seus mosaicos, e pelas suas termas, que estão entre as mais importantes no país.', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/Roman_Villa_of_Pis%C3%B5es%2C_Portugal_%2816614021360%29.jpg/1280px-Roman_Villa_of_Pis%C3%B5es%2C_Portugal_%2816614021360%29.jpg', 'https://i.gyazo.com/5cd59db8cda01ae5057529724bee4f84.png')");

                            db.execSQL("INSERT INTO InterestPoint (idPoint, eachInterestID, name, description, images, maps) VALUES ('12', '3', 'Antigo complexo termal', 'Um complexo termal, equipado com um hipocausto para aquecimento, decorado com placas de mármore. Uma das salas apresenta no seu interior um tanque com cobertura de mosaicos marinhos, que seria talvez utilizado como modo de amenizar a sala, de forma a providenciar um espaço para lazer onde os habitantes podiam refugiar-se do calor, durante os meses mais quentes. A fachada principal do edifício estava orientada para Sul, e pode ter incluído um espelho de água, que era um dos maiores da península, neste tipo de edifícios.', 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/de/Roman_Villa_of_Pis%C3%B5es%2C_Portugal_%2816615278039%29.jpg/1280px-Roman_Villa_of_Pis%C3%B5es%2C_Portugal_%2816615278039%29.jpg', '')");

                            db.execSQL("INSERT INTO InterestPoint (idPoint, eachInterestID, name, description, images, maps) VALUES ('13', '3', 'Antigo tanque ou piscina', 'A uma distância de cerca de 200 m da villa foi descoberto o paredão de uma barragem, que servia para fornecer a casa e a exploração agrícola e pecuária. Com efeito, a casa possuía várias estruturas que aproveitavam o abastecimento de água, como a zona das termas e vários grandes tanques e piscinas. Esta estrutura estava situada na Ribeira da Chaminé, formando uma albufeira com 340 m de comprimento e uma área inundada de 31300 m², e uma capacidade máxima de 38 mil m³ de água.', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Roman_Villa_of_Pis%C3%B5es%2C_Portugal_%2816800286391%29.jpg/1280px-Roman_Villa_of_Pis%C3%B5es%2C_Portugal_%2816800286391%29.jpg', '')");

                            db.execSQL("INSERT INTO InterestPoint (idPoint, eachInterestID, name, description, images, maps) VALUES ('14', '3', 'Mosaico com formas de peixes', 'Um dos motivos pelo qual a villa é conhecida são os seus mosaicos, tanto a duas cores como policromáticos, criando formas geométricas ou de teor natural. Os desenhos geométricos são circunferências, quadrados, triângulos, hexágonos, cruzes, suásticas e delta, enquanto que os temas naturais incluem pombas e animais marinhos, como uma enguia e um peixe.', 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Mosaic_floor%2C_Roman_Villa_of_Pis%C3%B5es%2C_Lusitania%2C_Portugal_%2813029897684%29.jpg/1280px-Mosaic_floor%2C_Roman_Villa_of_Pis%C3%B5es%2C_Lusitania%2C_Portugal_%2813029897684%29.jpg', '')");

                            db.execSQL("INSERT INTO InterestPoint (idPoint, eachInterestID, name, description, images, maps) VALUES ('15', '3', 'Mosaico com motivos geométricos e vegetalistas', 'A villa de Pisões é uma das mais importantes e melhor conservadas estruturas deste tipo, em toda a Península Ibérica. É um dos mais relevantes vestígios do período romano no concelho de Beja, e uma das villas romanas mais originais em toda a península.', 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/69/Mosaic_floor_with_geometric_and_naturalistic_motifs%2C_Roman_Villa_of_Pis%C3%B5es%2C_Lusitania%2C_Portugal_%2813029474925%29.jpg/1280px-Mosaic_floor_with_geometric_and_naturalistic_motifs%2C_Roman_Villa_of_Pis%C3%B5es%2C_Lusitania%2C_Portugal_%2813029474925%29.jpg', '')");

                            db.execSQL("INSERT INTO InterestPoint (idPoint, eachInterestID, name, description, images, maps) VALUES ('16', '3', 'Ruínas de Pisões, em 1998', 'A zona em que se insere a villa de Pisões já era habitada antes do período romano, como pode ser comprovado pelos vestígios encontrados no sítio arqueológico Pisões 5, incluindo duas fossas funerárias, um ossário, ferramentas e adornos do neolítico final, fossas, peças decorativas e cerâmica dos finais da Idade do Bronze, e vestígios de edifícios, cerâmica e utensílios da segunda Idade do ferro.', 'https://upload.wikimedia.org/wikipedia/commons/b/bf/Pis%C3%B5es_Villa_Rustica.jpg', '')");

                        }
                    })
                    .build();
        }
        return INSTANCE;
    }
}
