-- 비트 연산자 활용.
select count(*) count
from ECOLI_DATA
where GENOTYPE & 2 = 0 and (GENOTYPE & 4 = 4 or GENOTYPE & 1 = 1)