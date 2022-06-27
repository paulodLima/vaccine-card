SET search_path TO "DBVACCINE";

SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE TB_DISEASE;
TRUNCATE TABLE TB_COMPOSITION;
TRUNCATE TABLE TB_DOSAGE;
TRUNCATE TABLE TB_ROUTE_ADMINISTRATION;
TRUNCATE TABLE TB_NEEDLE;
TRUNCATE TABLE TB_SIDE_EFFECT;
TRUNCATE TABLE TB_APPLICATION_LOCATION;
TRUNCATE TABLE TB_VALIDITY_AFTER_OPEN;
TRUNCATE TABLE TB_REINFORCEMENT;
TRUNCATE TABLE TB_RECOMMENDED_AGE;
TRUNCATE TABLE TB_BASIC_VACCINATION;
TRUNCATE TABLE TB_VACCINE;
SET FOREIGN_KEY_CHECKS = 1;

insert into "TB_DISEASE"("ID_DISEASE", "UUID", "DESCRIPTION", "DT_INCLUSION")
values ('1', '45b7d9a5-c2f1-4332-9e4e-d11733f67ce0', 'Tuberculose', current_timestamp);
insert into "TB_DISEASE"("ID_DISEASE", "UUID", "DESCRIPTION", "DT_INCLUSION")
values ('2', '869c01f7-0cfb-4644-89cc-f119e1c790fc', 'Hepatite A', current_timestamp);
insert into "TB_COMPOSITION"("ID_COMPOSITION", "UUID", "DESCRIPTION", "DT_INCLUSION")
values ('1', '45b7d9a5-c2f1-4332-9e4e-d11733f67ce0', 'Virus vivo atenuado', current_timestamp);
insert into "TB_COMPOSITION"("ID_COMPOSITION", "UUID", "DESCRIPTION", "DT_INCLUSION")
values ('2', '869c01f7-0cfb-4644-89cc-f119e1c790fc', 'Bacteria viva atenuada', current_timestamp);
insert into "TB_ROUTE_ADMINISTRATION"("ID_ROUTE_ADMINISTRATION", "UUID", "DESCRIPTION", "DT_INCLUSION")
values ('1', '45b7d9a5-c2f1-4332-9e4e-d11733f67ce0', 'Intradérmica', current_timestamp);
insert into "TB_ROUTE_ADMINISTRATION"("ID_ROUTE_ADMINISTRATION", "UUID", "DESCRIPTION", "DT_INCLUSION")
values ('2', '869c01f7-0cfb-4644-89cc-f119e1c790fc', 'Intramuscular', current_timestamp);
insert into "TB_NEEDLE"("ID_NEEDLE", "UUID", "DESCRIPTION", "DT_INCLUSION")
values ('1', '45b7d9a5-c2f1-4332-9e4e-d11733f67ce0', '13x3,8', current_timestamp);
insert into "TB_NEEDLE"("ID_NEEDLE", "UUID", "DESCRIPTION", "DT_INCLUSION")
values ('2', '869c01f7-0cfb-4644-89cc-f119e1c790fc', '13x4,5', current_timestamp);
insert into "TB_SIDE_EFFECT"("ID_SIDE_EFFECT", "UUID", "DESCRIPTION", "DT_INCLUSION")
values ('1', '45b7d9a5-c2f1-4332-9e4e-d11733f67ce0', 'Poliomielite associada ao vírus vacinal – VAPP.',
        current_timestamp);
insert into "TB_SIDE_EFFECT"("ID_SIDE_EFFECT", "UUID", "DESCRIPTION", "DT_INCLUSION")
values ('2', '869c01f7-0cfb-4644-89cc-f119e1c790fc',
        'Reações locais.Febre, mialgia, cefaleia. D.Viscerotrópica. Aguda.', current_timestamp);
insert into "TB_APPLICATION_LOCATION"("ID_APPLICATION_LOCATION", "UUID", "DESCRIPTION", "DT_INCLUSION")
values ('1', '45b7d9a5-c2f1-4332-9e4e-d11733f67ce0', 'Cavidade oral', current_timestamp);
insert into "TB_APPLICATION_LOCATION"("ID_APPLICATION_LOCATION", "UUID", "DESCRIPTION", "DT_INCLUSION")
values ('2', '869c01f7-0cfb-4644-89cc-f119e1c790fc', 'Vasto lateral da coxa esquerda', current_timestamp);
insert into "TB_VALIDITY_AFTER_OPEN"("ID_VALIDITY_AFTER_OPEN", "UUID", "DESCRIPTION", "DT_INCLUSION")
values ('1', '45b7d9a5-c2f1-4332-9e4e-d11733f67ce0', '6 horas (multidose)', current_timestamp);
insert into "TB_VALIDITY_AFTER_OPEN"("ID_VALIDITY_AFTER_OPEN", "UUID", "DESCRIPTION", "DT_INCLUSION")
values ('2', '869c01f7-0cfb-4644-89cc-f119e1c790fc', '7 dias (multidose)', current_timestamp);
insert into "TB_REINFORCEMENT"("ID_REINFORCEMENT", "UUID", "DESCRIPTION", "DT_INCLUSION", "REINFORCEMENT")
values ('1', '45b7d9a5-c2f1-4332-9e4e-d11733f67ce0', '4 anos de idade', current_timestamp, 24);
insert into "TB_REINFORCEMENT"("ID_REINFORCEMENT", "UUID", "DESCRIPTION", "DT_INCLUSION", "REINFORCEMENT")
values ('2', '869c01f7-0cfb-4644-89cc-f119e1c790fc', '12 meses', current_timestamp, 36);
insert into "TB_RECOMMENDED_AGE"("ID_RECOMMENDED_AGE", "UUID", "DESCRIPTION", "DT_INCLUSION", "RECOMMENDED_AGE")
values ('1', '45b7d9a5-c2f1-4332-9e4e-d11733f67ce0', 'Ao nascer', current_timestamp, 1);
insert into "TB_RECOMMENDED_AGE"("ID_RECOMMENDED_AGE", "UUID", "DESCRIPTION", "DT_INCLUSION", "RECOMMENDED_AGE")
values ('2', '869c01f7-0cfb-4644-89cc-f119e1c790fc', '2 meses', current_timestamp, 2);
insert into "TB_DOSAGE"("ID_DOSAGE", "UUID", "DESCRIPTION", "DT_INCLUSION", "ID_RECOMMENDED_AGE", "ID_REINFORCEMENT")
values ('1', '45b7d9a5-c2f1-4332-9e4e-d11733f67ce0', '0,1 ml', current_timestamp, 1, 1);
insert into "TB_DOSAGE"("ID_DOSAGE", "UUID", "DESCRIPTION", "DT_INCLUSION", "ID_RECOMMENDED_AGE", "ID_REINFORCEMENT")
values ('2', '869c01f7-0cfb-4644-89cc-f119e1c790fc', '2 gotas', current_timestamp, 2, 2);
insert into "TB_BASIC_VACCINATION"("ID_BASIC_VACCINATION", "UUID", "DESCRIPTION", "DT_INCLUSION")
values ('1', '45b7d9a5-c2f1-4332-9e4e-d11733f67ce0', 'Dose única', current_timestamp);
insert into "TB_BASIC_VACCINATION"("ID_BASIC_VACCINATION", "UUID", "DESCRIPTION", "DT_INCLUSION")
values ('2', '869c01f7-0cfb-4644-89cc-f119e1c790fc', '2 doses', current_timestamp);

insert into "DBVACCINE"."TB_VACCINE"("ID_VACCINE", "UUID", "DESCRIPTION", "NAME",
                                     "ID_APPLICATION_LOCATION", "ID_BASIC_VACCINATION", "ID_COMPOSITION", "ID_DISEASE",
                                     "ID_NEEDLE", "ID_ROUTE_ADMINISTRATION", "ID_SIDE_EFFECT", "ID_VALIDITY_AFTER_OPEN",
                                     "DT_INCLUSION")
values ('101', '45b7d9a5-c2f1-4332-9e4e-d11733f67ce0', 'Vacina para turbeculose', 'BCG', '1', '1', '1', '1', '1', '1',
        '1', '1', current_timestamp);


insert into "DBVACCINE"."TB_VACCINE"("ID_VACCINE", "UUID", "DESCRIPTION", "NAME",
                                     "ID_APPLICATION_LOCATION", "ID_BASIC_VACCINATION", "ID_COMPOSITION", "ID_DISEASE",
                                     "ID_NEEDLE", "ID_ROUTE_ADMINISTRATION", "ID_SIDE_EFFECT", "ID_VALIDITY_AFTER_OPEN",
                                     "DT_INCLUSION")
values ('102', '869c01f7-0cfb-4644-89cc-f119e1c790fc', 'Vacina para febre amarela', 'Febre Amarela', '2', '2', '2', '2',
        '2', '2',
        '2', '2', current_timestamp);

insert into "DBVACCINE"."TB_VACCINE_DOSAGE"("ID_VACCINE", "ID_DOSAGE")
values ('101', '1');

insert into "DBVACCINE"."TB_VACCINE_DOSAGE"("ID_VACCINE", "ID_DOSAGE")
values ('101', '2');

insert into "DBVACCINE"."TB_VACCINE_DOSAGE"("ID_VACCINE", "ID_DOSAGE")
values ('102', '2');



