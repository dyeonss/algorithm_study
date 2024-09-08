def solution(video_len, pos, op_start, op_end, commands):
    pos=int(pos[:2])*60+int(pos[3:])
    op_start=int(op_start[:2])*60+int(op_start[3:])
    op_end=int(op_end[:2])*60+int(op_end[3:])
    video_len=int(video_len[:2])*60+int(video_len[3:])
    
    if op_start<=pos<=op_end:
            pos=op_end
            
    for command in commands:
        if command=='prev':
            pos=pos-10 if pos-10>=0 else 0
        elif command=='next':
            pos=pos+10 if pos+10<=video_len else video_len
        if op_start<=pos<=op_end:
            pos=op_end
    
    m=str(pos//60)
    s=str(pos%60)
    return ('0'+m if len(m)==1 else m)+':'+('0'+s if len(s)==1 else s)