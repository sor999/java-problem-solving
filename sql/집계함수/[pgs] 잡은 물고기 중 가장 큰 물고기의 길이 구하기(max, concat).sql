-- concat: 문자열 붙임.(숫자면 자동 문자열 변환. 소숫점 안없어짐) max: 소숫점 사라지진 않는데 문자열 변환시 없어짐
select concat(max(LENGTH), 'cm') as MAX_LENGTH
from FISH_INFO