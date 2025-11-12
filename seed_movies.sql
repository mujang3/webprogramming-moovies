SET NAMES utf8mb4;
SET collation_connection = utf8mb4_0900_ai_ci;

INSERT INTO movie
(title, description, director, genre, `year`, running_time, image_url, video_url, audio_url, created_at, updated_at)
VALUES
('그랜드 부다페스트 호텔','한때 명성을 떨쳤던 유럽의 호텔을 배경으로, 전설적인 컨시어지 구스타브와 벨보이 제로가 엉뚱하지만 따뜻한 모험을 펼치는 이야기. 특유의 색감과 대칭미로 유명한 웨스 앤더슨 감독의 대표작.','웨스 앤더슨','코미디',2014,99,'/images/budapest.jpg','/videos/budapest.mp4','/audios/budapest.mp3',NOW(),NOW()),
('듄','사막 행성 아라키스를 둘러싼 권력, 생존, 예언의 서사시. 폴 아트레이디스가 운명과 맞서 싸우며 성장하는 과정을 그린 SF 대작으로, 압도적인 영상미와 세계관으로 주목받았다.','드니 빌뇌브','SF',2021,155,'/images/dune.jpg','/videos/dune.mp4','/audios/dune.mp3',NOW(),NOW()),
('어벤져스: 엔드게임','타노스에게 패배한 후 절망에 빠진 어벤져스가 마지막 희망을 걸고 시간을 거슬러 올라가 세상을 구하려는 이야기를 그린 마블 시리즈의 대미를 장식한 작품.','안소니 루소, 조 루소','액션',2019,181,'/images/endgame.jpg','/videos/endgame.mp4','/audios/endgame.mp3',NOW(),NOW()),
('에브리씽 에브리웨어 올 앳 원스','중국계 이민자 여성 에블린이 갑자기 수많은 평행우주 속 자신의 삶을 동시에 경험하게 되며 벌어지는 기상천외한 이야기. 다중우주를 통해 가족과 삶의 의미를 되돌아보는 독창적인 영화.','다니엘 콴, 다니엘 쉐이너트','드라마',2022,139,'/images/everything.jpg','/videos/everything.mp4','/audios/everything.mp3',NOW(),NOW()),
('인셉션','남의 꿈속에 들어가 생각을 심는 특수요원 코브가 마지막 임무로 불가능한 “인셉션”에 도전하는 이야기. 꿈과 현실의 경계를 넘나드는 놀라운 서사와 심리적 긴장감이 돋보이는 SF 스릴러.','크리스토퍼 놀란','SF',2010,148,'/images/inception.jpg','/videos/inception.mp4','/audios/inception.mp3',NOW(),NOW()),
('인터스텔라','지구의 멸망을 앞두고 새로운 행성을 찾아 우주로 떠나는 탐사대의 이야기. 사랑, 시간, 과학을 넘나드는 거대한 스케일과 철학적 메시지가 감동을 전한다.','크리스토퍼 놀란','SF',2014,169,'/images/interstellar.jpg','/videos/interstellar.mp4','/audios/interstellar.mp3',NOW(),NOW()),
('조커','사회로부터 소외된 남자 아서 플렉이 점점 광기와 절망 속으로 빠져들며 조커로 변모하는 과정을 그린 영화. 인간 내면의 어둠을 강렬하게 표현한 심리 스릴러.','토드 필립스','드라마',2019,122,'/images/joker.jpg','/videos/joker.mp4','/audios/joker.mp3',NOW(),NOW()),
('라라랜드','꿈을 쫓는 재즈 피아니스트와 배우 지망생의 사랑과 현실을 그린 뮤지컬 영화. 황홀한 색감과 음악, 그리고 아름답지만 아픈 이별로 관객들의 마음을 울린 작품.','데이미언 셔젤','로맨스',2016,128,'/images/lalaland.jpg','/videos/lalaland.mp4','/audios/lalaland.mp3',NOW(),NOW()),
('기생충','가난한 가족이 부잣집에 차례로 위장 취업하면서 벌어지는 예측 불가한 사건을 통해 계층 간 격차와 인간의 본성을 풍자한 작품. 아카데미 4관왕을 달성한 한국 영화의 쾌거.','봉준호','드라마',2019,132,'/images/parasite.jpg','/videos/parasite.mp4','/audios/parasite.mp3',NOW(),NOW()),
('스파이더맨: 노 웨이 홈','정체가 드러난 피터 파커가 멀티버스의 문을 열게 되며 과거의 스파이더맨들과 마주하게 되는 이야기. 세 세대의 스파이더맨이 한자리에 모인 감동적인 크로스오버 영화.','존 왓츠','액션',2021,148,'/images/spiderman.jpg','/videos/spiderman.mp4','/audios/spiderman.mp3',NOW(),NOW()),
('타이타닉','1912년, 운명처럼 만난 잭과 로즈가 거대한 비극 속에서도 사랑을 나누는 이야기. 눈부신 로맨스와 비극적인 결말로 세대를 넘어 사랑받는 명작.','제임스 카메론','로맨스',1997,195,'/images/titanic.jpg','/videos/titanic.mp4','/audios/titanic.mp3',NOW(),NOW()),
('웡카','초콜릿 천재 윌리 웡카의 젊은 시절, 그의 상상력과 열정으로 세상을 바꿔가는 이야기를 담은 뮤지컬 판타지. 달콤한 비주얼과 따뜻한 메시지로 가족 모두가 즐길 수 있다.','폴 킹','판타지',2023,116,'/images/wonka.jpg','/videos/wonka.mp4','/audios/wonka.mp3',NOW(),NOW());
